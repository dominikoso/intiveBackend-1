package com.dominikoso.intiveBackend.controller;

import com.dominikoso.intiveBackend.dto.OrganizationDto;
import com.dominikoso.intiveBackend.model.Organization;
import com.dominikoso.intiveBackend.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/org")
@RestController
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @RequestMapping(value = "/all")
    public List<Organization> getOrganizationList() { return organizationService.findAll(); }

    @RequestMapping(value = "/read/{id}", method = RequestMethod.GET)
    public Organization readRecord(@PathVariable Long id) {return organizationService.findById(id);}
    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Organization createRecord (@RequestBody OrganizationDto organization) {return organizationService.save(organization);}
    @RequestMapping(value = "/update", method = RequestMethod.PATCH)
    public void updateRecord (@RequestBody Organization organization) {organizationService.update(organization);}
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE)
    public void deleteRecord (@RequestBody OrganizationDto organization) {organizationService.delete(organization.getId());}


}
