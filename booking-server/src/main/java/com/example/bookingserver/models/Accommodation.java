package com.example.bookingserver.models;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

@Entity
@Table(name = "accommodations")
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "photos")
    @ElementCollection
    private List<String> photos;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "perks", nullable = false)
    @ElementCollection
    private List<String> perks;

    @Column(name = "extra_info")
    private String extraInfo;

    @Column(name = "check_in_time", nullable = false)
    private LocalTime checkIn;

    @Column(name = "check_out_time", nullable = false)
    private LocalTime checkOut;

    @Column(name = "number_of_guests", nullable = false)
    private int guests;

    // Constructor
    public Accommodation() {}

    public Accommodation(String title, String address, List<String> photos, String description, List<String> perks, String extraInfo, LocalTime checkIn, LocalTime checkOut, int guests) {
        this.title = title;
        this.address = address;
        this.photos = photos;
        this.description = description;
        this.perks = perks;
        this.extraInfo = extraInfo;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guests = guests;
    }

    // Getters & Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPerks() {
        return perks;
    }

    public void setPerks(List<String> perks) {
        this.perks = perks;
    }

    public String getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(String extraInfo) {
        this.extraInfo = extraInfo;
    }

    public LocalTime getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(LocalTime checkIn) {
        this.checkIn = checkIn;
    }

    public LocalTime getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(LocalTime checkOut) {
        this.checkOut = checkOut;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }
}
