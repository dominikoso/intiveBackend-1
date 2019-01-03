package com.dominikoso.intiveBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

@Entity
public class ConferenceRoomReservation implements Serializable {

    ///// Variables //////

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    //@NotEmpty(message = "Organization Name cannot be empty or blank")
    @ManyToOne
    @JoinColumn(name = "orgName", referencedColumnName = "orgName")
    //@Size(min=2,max=20, message = "Length of Organization Name greater than or equal 2 and less than or equal 20")
    private Organization organization;

    @Column(name="reservationStartDate")
    private Date startDate;

    @Column(name="reservationEndDate")
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "conferenceRoomId")
    private ConferenceRoom conferenceRoom;

    ///// Getters and Setters //////

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ConferenceRoom getConferenceRoom() {
        return conferenceRoom;
    }

    public void setConferenceRoom(ConferenceRoom conferenceRoom) {
        this.conferenceRoom = conferenceRoom;
    }

//    public String getRoomName() {
//        return roomName;
//    }
//
//    public void setRoomName(String roomName) {
//        this.roomName = roomName;
//    }


}
