package com.dominikoso.intiveBackend.service;

import com.dominikoso.intiveBackend.dto.ConferenceRoomReservationDto;
import com.dominikoso.intiveBackend.model.ConferenceRoomReservation;

import java.util.List;

public interface ConferenceRoomReservationService {
    ConferenceRoomReservation findById(Long id);
    List<ConferenceRoomReservation> findAll();
    ConferenceRoomReservation save(ConferenceRoomReservationDto conferenceRoomReservation);
    void update(ConferenceRoomReservation conferenceRoomReservation);
    void delete(Long id);
}
