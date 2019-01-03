package com.dominikoso.intiveBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "organization")
public class Organization {

    ///// Variables //////

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "orgName", unique = true)
    @NotEmpty(message = "Organization Name cannot be empty or blank")
    @Size(min=1,max=20)
    private String orgName;

    ///// Getters and Setters //////

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getOrgName() { return orgName; }

    public void setOrgName(String orgName) { this.orgName = orgName; }
}
