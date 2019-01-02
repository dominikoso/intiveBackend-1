package com.dominikoso.intiveBackend.service.serviceImpl;

import com.dominikoso.intiveBackend.model.ConferenceRoom;
import com.dominikoso.intiveBackend.repository.ConferenceRoomRepository;
import com.dominikoso.intiveBackend.service.ConferenceRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value="conferenceRoomService")
public class ConferenceRoomServiceImpl implements ConferenceRoomService {

    @Autowired
    private ConferenceRoomRepository conferenceRoomRepository;

    public List<ConferenceRoom> findAll() {
        List<ConferenceRoom> list = new ArrayList<>();
        conferenceRoomRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}
