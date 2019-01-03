package com.dominikoso.intiveBackend.service.serviceImpl;

import com.dominikoso.intiveBackend.dto.OrganizationDto;
import com.dominikoso.intiveBackend.model.Organization;
import com.dominikoso.intiveBackend.repository.OrganizationRepository;
import com.dominikoso.intiveBackend.service.OrganizationService;
import com.dominikoso.intiveBackend.tools.CopyNonNullPropetiesTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value="organizationService")
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public Organization findByOrgName(String orgName){
        return organizationRepository.findByOrgName(orgName);
    }

    @Override
    public Organization findById(Long id){
        return organizationRepository.findById(id).orElse(null);
    }

    public List<Organization> findAll() {
        List<Organization> list = new ArrayList<>();
        organizationRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public void update(Organization organization){
        Long id = organization.getId();
        Organization forUpdate = organizationRepository.findById(id).orElse(null);
        CopyNonNullPropetiesTool.copyNonNullProperties(forUpdate, organization);
        organizationRepository.save(forUpdate);
    }

    @Override
    public void delete(Long id){
        organizationRepository.deleteById(id);
    }

    @Override
    public Organization save(OrganizationDto organization) {
        Organization newOrganization = new Organization();
        newOrganization.setOrgName(organization.getOrgName());
        return organizationRepository.save(newOrganization);
    }


}
