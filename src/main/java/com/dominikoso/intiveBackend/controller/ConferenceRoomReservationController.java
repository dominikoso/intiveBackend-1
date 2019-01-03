package com.dominikoso.intiveBackend.controller;

import com.dominikoso.intiveBackend.dto.ConferenceRoomReservationDto;
import com.dominikoso.intiveBackend.model.ConferenceRoomReservation;
import com.dominikoso.intiveBackend.service.ConferenceRoomReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/croom_res")
@RestController
public class ConferenceRoomReservationController {
    @Autowired
    ConferenceRoomReservationService conferenceRoomReservationService;

    @RequestMapping("/all")
    public List<ConferenceRoomReservation> getConferenceRoomsList(){ return conferenceRoomReservationService.findAll(); }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public ConferenceRoomReservation readRecord(@PathVariable Long id) {return conferenceRoomReservationService.findById(id);}
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ConferenceRoomReservation createRecord (@RequestBody ConferenceRoomReservationDto conferenceRoomReservation) {return conferenceRoomReservationService.save(conferenceRoomReservation);}
    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void updateRecord (@RequestBody ConferenceRoomReservation conferenceRoomReservation) {conferenceRoomReservationService.update(conferenceRoomReservation);}
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteRecord (@RequestBody ConferenceRoomReservationDto conferenceRoomReservation) {conferenceRoomReservationService.delete(conferenceRoomReservation.getId());}

}
