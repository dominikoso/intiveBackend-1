package com.dominikoso.intiveBackend.service.serviceImpl;

import com.dominikoso.intiveBackend.dto.OrganizationDto;
import com.dominikoso.intiveBackend.model.Organization;
import com.dominikoso.intiveBackend.repository.OrganizationRepository;
import com.dominikoso.intiveBackend.service.OrganizationService;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service(value="organizationService")
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationRepository organizationRepository;

    @Override
    public Organization findById(Long id){
        return organizationRepository.findById(id).orElse(null);
    }

    public List<Organization> findAll() {
        List<Organization> list = new ArrayList<>();
        organizationRepository.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    public static Object copyNonNullProperties(Object target, Object in) {
        if (in == null || target == null || target.getClass() != in.getClass()) return null;

        final BeanWrapper src = new BeanWrapperImpl(in);
        final BeanWrapper trg = new BeanWrapperImpl(target);

        for (final Field property : target.getClass().getDeclaredFields()) {
            Object providedObject = src.getPropertyValue(property.getName());
            if ((providedObject != null && !(providedObject instanceof Collection<?>))) {
                trg.setPropertyValue(
                        property.getName(),
                        providedObject);
            }
        }
        return target;
    }

    @Override
    public void update(Organization organization){
        Long id = organization.getId();
        Organization forUpdate = organizationRepository.findById(id).orElse(null);
        copyNonNullProperties(forUpdate, organization);
        organizationRepository.save(forUpdate);
    }

    @Override
    public void delete(Long id){
        organizationRepository.deleteById(id);
    }

    @Override
    public Organization save(OrganizationDto organization){
        Organization newOrganization = new Organization();
        newOrganization.setOrgName(organization.getOrgName());
        return organizationRepository.save(newOrganization);
    }


}