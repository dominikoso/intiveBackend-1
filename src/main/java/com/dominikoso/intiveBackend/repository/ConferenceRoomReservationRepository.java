package com.dominikoso.intiveBackend.repository;

import com.dominikoso.intiveBackend.model.ConferenceRoomReservation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRoomReservationRepository extends CrudRepository<ConferenceRoomReservation, Long> {

}
