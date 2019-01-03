package com.dominikoso.intiveBackend.repository;

import com.dominikoso.intiveBackend.model.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizationRepository extends CrudRepository<Organization, Long> {
    Organization findByOrgName(String orgName);
}
