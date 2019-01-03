package com.dominikoso.intiveBackend.service;

import com.dominikoso.intiveBackend.dto.ConferenceRoomDto;
import com.dominikoso.intiveBackend.model.ConferenceRoom;

import java.util.List;

public interface ConferenceRoomService {
    ConferenceRoom findById(Long id);
    List<ConferenceRoom> findAll();
    ConferenceRoom save(ConferenceRoomDto conferenceRoom);
    void update(ConferenceRoom conferenceRoom);
    void delete(Long id);
}
