package com.dominikoso.intiveBackend.controller;

import com.dominikoso.intiveBackend.dto.ConferenceRoomDto;
import com.dominikoso.intiveBackend.model.ConferenceRoom;
import com.dominikoso.intiveBackend.service.ConferenceRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/croom")
@RestController
public class ConferenceRoomController {
    @Autowired
    private ConferenceRoomService conferenceRoomService;

    @RequestMapping("/all")
    public List<ConferenceRoom> getConferenceRoomsList(){ return conferenceRoomService.findAll(); }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public ConferenceRoom readRecord(@PathVariable Long id) {return conferenceRoomService.findById(id);}
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ConferenceRoom createRecord (@RequestBody ConferenceRoomDto conferenceRoom) {return conferenceRoomService.save(conferenceRoom);}
    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void updateRecord (@RequestBody ConferenceRoom conferenceRoom) {conferenceRoomService.update(conferenceRoom);}
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteRecord (@RequestBody ConferenceRoomDto conferenceRoom) {conferenceRoomService.delete(conferenceRoom.getId());}
}
