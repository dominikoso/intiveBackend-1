package com.dominikoso.intiveBackend.dto;

public class ConferenceRoomDto {

    ///// Variables //////

    private Long id;
    private String roomName;
    private String roomId;
    private Integer floor;
    private Integer seats;
    private Integer standingPlaces;
    private Integer hammocks;
    private Boolean available = true;

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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }


}
