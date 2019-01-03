package com.dominikoso.intiveBackend.repository;

import com.dominikoso.intiveBackend.model.ConferenceRoom;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConferenceRoomRepository extends CrudRepository<ConferenceRoom, Long> {
    ConferenceRoom findByRoomName(String roomName);
}
