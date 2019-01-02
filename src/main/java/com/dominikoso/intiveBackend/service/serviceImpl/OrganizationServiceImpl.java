package com.dominikoso.intiveBackend.service.serviceImpl;

import com.dominikoso.intiveBackend.model.Organization;
import com.dominikoso.intiveBackend.repository.OrganizationRepository;
import com.dominikoso.intiveBackend.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value="organizationService")
public class OrganizationServiceImpl implements OrganizationService {
    @Autowired
    private OrganizationRepository organizationRepository;

    public List<Organization> findAll() {
        List<Organization> list = new ArrayList<>();
        organizationRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }
}
