package com.dominikoso.intiveBackend.service;

import com.dominikoso.intiveBackend.dto.OrganizationDto;
import com.dominikoso.intiveBackend.model.Organization;

import java.util.List;

public interface OrganizationService {
    Organization findById(Long id);
    List<Organization> findAll();
    Organization save(OrganizationDto organization);
    void update(Organization organization);
    void delete(Long id);
}
