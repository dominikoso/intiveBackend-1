package com.dominikoso.intiveBackend.service;

import com.dominikoso.intiveBackend.dto.ConferenceRoomDto;
import com.dominikoso.intiveBackend.model.ConferenceRoom;

import java.util.List;

public interface ConferenceRoomService {
    ConferenceRoom save(ConferenceRoomDto conferenceRoom);
    List<ConferenceRoom> findAll();
}
