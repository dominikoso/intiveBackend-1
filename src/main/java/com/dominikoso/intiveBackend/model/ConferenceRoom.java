package com.dominikoso.intiveBackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="conference_Room")
public class ConferenceRoom {

    ///// Variables //////

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "roomName", unique = true)
    @NotEmpty(message = "Room name cannot be empty or blank")
    @Size(min=1,max=20, message = "Room name cannot be empty or blank")
    private String roomName;

    @Column(name = "roomId", unique = true)
    @Size(max=20, message = "Room Id length must be lower than or equal 20")
    private String roomId;

    @Column(name="floor")
    @Range(min=0, max=10, message = "Floor must not be greater than 10 and lower than 0")
    private Integer floor;

    @Column(name="available", columnDefinition = "boolean default true")
    private Boolean available;

    @Column(name="seats")
    @Range(min=0)
    private Integer seats;

    @Column(name="standingPlaces")
    @Range(min=0)
    private Integer standingPlaces;

    @Column(name="hammocks")
    @Range(min=0)
    private Integer hammocks;

    ///// Getters and Setters //////

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomId() {
        return roomId;
    }

    public void setRoomId(String roomId) {
        this.roomId = roomId;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Boolean getAvailable() { return available; }

    public void setAvailable(Boolean available) { this.available = available; }

    public Integer getSeats() {
        return seats;
    }

    public void setSeats(Integer seats) {
        this.seats = seats;
    }

    public Integer getStandingPlaces() {
        return standingPlaces;
    }

    public void setStandingPlaces(Integer standingPlaces) {
        this.standingPlaces = standingPlaces;
    }

    public Integer getHammocks() {
        return hammocks;
    }

    public void setHammocks(Integer hammocks) {
        this.hammocks = hammocks;
    }

}
