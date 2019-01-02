package com.dominikoso.intiveBackend.controller;

import com.dominikoso.intiveBackend.model.ConferenceRoom;
import com.dominikoso.intiveBackend.service.ConferenceRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/croom")
@RestController
public class ConferenceRoomController {
    @Autowired
    private ConferenceRoomService conferenceRoomService;

    @RequestMapping("/all")
    public List<ConferenceRoom> getConferenceRoomsList(){ return conferenceRoomService.findAll(); }
}
