package com.dominikoso.intiveBackend.controller;

import com.dominikoso.intiveBackend.model.Organization;
import com.dominikoso.intiveBackend.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/org")
@RestController
public class OrganizationController {
    @Autowired
    private OrganizationService organizationService;

    @RequestMapping("/all")
    public List<Organization> getOrganizationList() { return organizationService.findAll(); }
}
