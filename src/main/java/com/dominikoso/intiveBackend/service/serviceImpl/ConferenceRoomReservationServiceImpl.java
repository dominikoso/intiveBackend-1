package com.dominikoso.intiveBackend.service.serviceImpl;

import com.dominikoso.intiveBackend.dto.ConferenceRoomReservationDto;
import com.dominikoso.intiveBackend.model.ConferenceRoomReservation;
import com.dominikoso.intiveBackend.repository.ConferenceRoomReservationRepository;
import com.dominikoso.intiveBackend.service.ConferenceRoomReservationService;
import com.dominikoso.intiveBackend.service.ConferenceRoomService;
import com.dominikoso.intiveBackend.service.OrganizationService;
import com.dominikoso.intiveBackend.tools.CopyNonNullPropetiesTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value="conferenceRoomReservationService")
public class ConferenceRoomReservationServiceImpl implements ConferenceRoomReservationService {

    @Autowired
    private ConferenceRoomReservationRepository conferenceRoomReservationRepository;

    @Autowired
    private ConferenceRoomService conferenceRoomService;

    @Autowired
    private OrganizationService organizationService;

    @Override
    public ConferenceRoomReservation findById(Long id){ return conferenceRoomReservationRepository.findById(id).orElse(null); }

    public List<ConferenceRoomReservation> findAll() {
        List<ConferenceRoomReservation> list = new ArrayList<>();
        conferenceRoomReservationRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public ConferenceRoomReservation save(ConferenceRoomReservationDto conferenceRoomReservation){
        ConferenceRoomReservation newConferenceRoomReservation = new ConferenceRoomReservation();
        newConferenceRoomReservation.setStartDate(conferenceRoomReservation.getStartDate());
        newConferenceRoomReservation.setEndDate(conferenceRoomReservation.getEndDate());
        newConferenceRoomReservation.setOrganization(organizationService.findByOrgName(conferenceRoomReservation.getOrgName()));
        newConferenceRoomReservation.setConferenceRoom(conferenceRoomService.findByRoomName(conferenceRoomReservation.getConferenceRoomName()));
        return conferenceRoomReservationRepository.save(newConferenceRoomReservation);
    }

    @Override
    public void update(ConferenceRoomReservation conferenceRoomReservation){
        Long id = conferenceRoomReservation.getId();
        ConferenceRoomReservation forUpdate = conferenceRoomReservationRepository.findById(id).orElse(null);
        CopyNonNullPropetiesTool.copyNonNullProperties(forUpdate, conferenceRoomReservation);
        conferenceRoomReservationRepository.save(forUpdate);
    }

    @Override
    public void delete(Long id){
        conferenceRoomReservationRepository.deleteById(id);
    }


}
