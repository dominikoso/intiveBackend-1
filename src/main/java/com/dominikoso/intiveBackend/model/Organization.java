package com.dominikoso.intiveBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "organization")
public class Organization implements Serializable {

    ///// Variables //////

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "orgId")
    private Long id;

    @NaturalId
    @Column(name = "orgName", unique = true)
    @NotEmpty(message = "Organization Name cannot be empty or blank")
    @Size(min=2,max=20, message = "Length of Organization Name greater than or equal 2 and less than or equal 20")
    private String orgName;

    @JsonIgnore
    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private Set<ConferenceRoomReservation> conferenceRoomReservations;

    ///// Getters and Setters //////

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getOrgName() { return orgName; }

    public void setOrgName(String orgName) { this.orgName = orgName; }
}
