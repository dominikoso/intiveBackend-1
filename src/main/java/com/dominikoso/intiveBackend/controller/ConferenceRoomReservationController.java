package com.dominikoso.intiveBackend.controller;

import com.dominikoso.intiveBackend.dto.ConferenceRoomReservationDto;
import com.dominikoso.intiveBackend.model.ConferenceRoomReservation;
import com.dominikoso.intiveBackend.service.ConferenceRoomReservationService;
import com.dominikoso.intiveBackend.tools.ConstraintViolationExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;

// TO DO IN FUTURE - REMOVE DUPLICATES
@SuppressWarnings("Duplicates")
@RequestMapping("/croom_res")
@RestController
public class ConferenceRoomReservationController {
    @Autowired
    ConferenceRoomReservationService conferenceRoomReservationService;

    @RequestMapping("/all")
    public List<ConferenceRoomReservation> getConferenceRoomsList(){ return conferenceRoomReservationService.findAll(); }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public ResponseEntity readRecord(@PathVariable Long id) {
        if (conferenceRoomReservationService.findById(id) == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot find requested record");
        } else {
            return ResponseEntity.ok(conferenceRoomReservationService.findById(id));
        }
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity createRecord (@RequestBody ConferenceRoomReservationDto conferenceRoomReservation) {
        Object response;
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            response = conferenceRoomReservationService.save(conferenceRoomReservation);
        }catch (DataAccessException e){
            response = "Failed to create record: \n"+e.getMessage();
            responseStatus = HttpStatus.BAD_REQUEST;
        }catch (ConstraintViolationException e){
            response = "Failed to create record: \n";
            response += ConstraintViolationExceptionHandler.ValidateAndReturnExceptionResponse(e);
            responseStatus = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(responseStatus).body(response);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public ResponseEntity updateRecord (@RequestBody ConferenceRoomReservation conferenceRoomReservation) {
        String response = "Successfully updated record";
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            conferenceRoomReservationService.update(conferenceRoomReservation);
        }catch (DataAccessException e){
            response = "Failed to update record: \n"+e.getMessage();
            responseStatus = HttpStatus.BAD_REQUEST;
        }catch (ConstraintViolationException e){
            response = "Failed to update record: \n";
            response += ConstraintViolationExceptionHandler.ValidateAndReturnExceptionResponse(e);
            responseStatus = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(responseStatus).body(response);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteRecord (@RequestBody ConferenceRoomReservationDto conferenceRoomReservation) {
        String response = "Successfully deleted record";
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            conferenceRoomReservationService.delete(conferenceRoomReservation.getId());
        }catch (DataAccessException e){
            response = "Failed to delete record: "+e.getMessage();
            responseStatus = HttpStatus.BAD_REQUEST;
        }catch (ConstraintViolationException e){
            response = "Failed to delete record: \n";
            response += ConstraintViolationExceptionHandler.ValidateAndReturnExceptionResponse(e);
            responseStatus = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(responseStatus).body(response);

    }

}
