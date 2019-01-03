package com.dominikoso.intiveBackend.controller;

import com.dominikoso.intiveBackend.dto.OrganizationDto;
import com.dominikoso.intiveBackend.model.Organization;
import com.dominikoso.intiveBackend.service.OrganizationService;
import com.dominikoso.intiveBackend.tools.ConstraintViolationExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolationException;
import java.util.List;

// TO DO IN FUTURE - REMOVE DUPLICATES
// Make Messages into global variables
@SuppressWarnings("Duplicates")
@RequestMapping("/org")
@RestController
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(value = "/all")
    public List<Organization> getOrganizationList() { return organizationService.findAll(); }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public ResponseEntity readRecord(@PathVariable Long id) {
        if(organizationService.findById(id) == null){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cannot find requested record");
        }else{
            return ResponseEntity.ok(organizationService.findById(id));}}

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity createRecord (@RequestBody OrganizationDto organization) {
        Object response;
        HttpStatus responseStatus = HttpStatus.OK;
        try {
           response = organizationService.save(organization);
        }catch (DataAccessException e){
            response = "Failed to create record: Organization with specified name already exist";
            responseStatus = HttpStatus.BAD_REQUEST;
        }catch (ConstraintViolationException e){
            response = "Failed to create record: \n";
            response += ConstraintViolationExceptionHandler.ValidateAndReturnExceptionResponse(e);
            responseStatus = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(responseStatus).body(response);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public ResponseEntity updateRecord (@RequestBody Organization organization) {
        String response = "Successfully updated record";
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            organizationService.update(organization);
        }catch (DataAccessException e){
            response = "Failed to update record: "+e.getMessage();
            responseStatus = HttpStatus.BAD_REQUEST;
        }catch (ConstraintViolationException e){
            response = "Failed to update record: \n";
            response += ConstraintViolationExceptionHandler.ValidateAndReturnExceptionResponse(e);
            responseStatus = HttpStatus.BAD_REQUEST;
        }
        return ResponseEntity.status(responseStatus).body(response);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public ResponseEntity deleteRecord (@RequestBody OrganizationDto organization) {
        String response = "Successfully deleted record";
        HttpStatus responseStatus = HttpStatus.OK;
        try {
            organizationService.delete(organization.getId());
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

