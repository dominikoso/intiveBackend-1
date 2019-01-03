package com.dominikoso.intiveBackend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class OrganizationDto {

    ///// Variables //////

    private Long id;
    private String orgName;

    ///// Getters And Setters //////

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }
}
