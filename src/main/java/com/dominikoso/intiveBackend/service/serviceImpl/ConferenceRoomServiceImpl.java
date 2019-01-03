package com.dominikoso.intiveBackend.service.serviceImpl;

import com.dominikoso.intiveBackend.dto.ConferenceRoomDto;
import com.dominikoso.intiveBackend.model.ConferenceRoom;
import com.dominikoso.intiveBackend.repository.ConferenceRoomRepository;
import com.dominikoso.intiveBackend.service.ConferenceRoomService;
import com.dominikoso.intiveBackend.tools.CopyNonNullPropetiesTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value="conferenceRoomService")
public class ConferenceRoomServiceImpl implements ConferenceRoomService {

    @Autowired
    private ConferenceRoomRepository conferenceRoomRepository;

    @Override
    public ConferenceRoom findById(Long id){ return conferenceRoomRepository.findById(id).orElse(null); }

    public List<ConferenceRoom> findAll() {
        List<ConferenceRoom> list = new ArrayList<>();
        conferenceRoomRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public ConferenceRoom save(ConferenceRoomDto conferenceRoom){
        ConferenceRoom newRoom = new ConferenceRoom();
            newRoom.setRoomName(conferenceRoom.getRoomName());
            newRoom.setRoomId(conferenceRoom.getRoomId());
            newRoom.setFloor(conferenceRoom.getFloor());
            newRoom.setSeats(conferenceRoom.getSeats());
            newRoom.setStandingPlaces(conferenceRoom.getStandingPlaces());
            newRoom.setHammocks(conferenceRoom.getHammocks());
            newRoom.setAvailable(conferenceRoom.getAvailable());
        return conferenceRoomRepository.save(newRoom);
    }

    @Override
    public void update(ConferenceRoom conferenceRoom){
        Long id = conferenceRoom.getId();
        ConferenceRoom forUpdate = conferenceRoomRepository.findById(id).orElse(null);
        CopyNonNullPropetiesTool.copyNonNullProperties(forUpdate, conferenceRoom);
        conferenceRoomRepository.save(forUpdate);
    }

    @Override
    public void delete(Long id){
        conferenceRoomRepository.deleteById(id);
    }
}
