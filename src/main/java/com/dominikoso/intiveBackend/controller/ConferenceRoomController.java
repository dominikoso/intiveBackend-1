package com.dominikoso.intiveBackend.controller;

import com.dominikoso.intiveBackend.dto.ConferenceRoomDto;
import com.dominikoso.intiveBackend.model.ConferenceRoom;
import com.dominikoso.intiveBackend.service.ConferenceRoomService;
import com.dominikoso.intiveBackend.tools.ConstraintViolationExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;

// TO DO IN FUTURE - REMOVE DUPLICATES
@SuppressWarnings("Duplicates")
@RequestMapping("/croom")
@RestController
public class ConferenceRoomController {
    @Autowired
    private ConferenceRoomService conferenceRoomService;

    @RequestMapping("/all")
    public List<ConferenceRoom> getConferenceRoomsList(){ return conferenceRoomService.findAll(); }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public ResponseEntity readRecord(@PathVariable Long id) {
        if (conferenceRoomService.findById(id) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot find requested record");
        } else {
            return ResponseEntity.ok(conferenceRoomService.findById(id));
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity createRecord (@RequestBody ConferenceRoomDto ConferenceRoom) {
        Object response;
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            response = conferenceRoomService.save(ConferenceRoom);
        }catch (DataAccessException e){
            response = "Failed to Create Record: Room with specified name or Id already exist";
            responseStatus = HttpStatus.BAD_REQUEST;
        }catch (ConstraintViolationException e){
            response = "Failed to create record: \n";
            response += ConstraintViolationExceptionHandler.ValidateAndReturnExceptionResponse(e);
            responseStatus = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(responseStatus).body(response);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public ResponseEntity updateRecord (@RequestBody ConferenceRoom ConferenceRoom) {
        String response = "Successfully Updated Record";
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            conferenceRoomService.update(ConferenceRoom);
        }catch (DataAccessException e){
            response = "Failed to Update Record: "+e.getMessage();
            responseStatus = HttpStatus.BAD_REQUEST;
        }catch (ConstraintViolationException e){
            response = "Failed to update record: \n";
            response += ConstraintViolationExceptionHandler.ValidateAndReturnExceptionResponse(e);
            responseStatus = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(responseStatus).body(response);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteRecord (@RequestBody ConferenceRoomDto ConferenceRoom) {
        String response = "Successfully Deleted Record";
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            conferenceRoomService.delete(ConferenceRoom.getId());
        }catch (DataAccessException e){
            response = "Failed to Delete Record: "+e.getMessage();
            responseStatus = HttpStatus.BAD_REQUEST;
        }catch (ConstraintViolationException e){
            response = "Failed to delete record: \n";
            response += ConstraintViolationExceptionHandler.ValidateAndReturnExceptionResponse(e);
            responseStatus = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(responseStatus).body(response);

    }

}

