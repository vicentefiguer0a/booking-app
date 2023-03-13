package com.example.bookingserver.models;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

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

    @Column(name = "description", nullable = false)
    private String description;

    @ElementCollection
    @CollectionTable(name = "accommodation_perks", joinColumns = {@JoinColumn(name = "id")})
    @Column(name = "perks")
    private List<String> perks;

    @Column(name = "extra_info")
    private String extraInfo;

    @Column(name = "check_in_time", nullable = false)
    private String checkIn;

    @Column(name = "check_out_time", nullable = false)
    private String checkOut;

    @Column(name = "number_of_guests", nullable = false)
    private int guests;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User owner;

//    @JoinTable(name = "accommodation_images",
//            joinColumns = {
//                @JoinColumn(name = "accommodation_id")
//            },
//            inverseJoinColumns = {
//                @JoinColumn(name = "image_id")
//            }
//    )
    @OneToMany(mappedBy = "accommodation", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AccommodationImage> accommodationImages;

    // Constructor
    public Accommodation() {}

    public Accommodation(String title, String address, String description, List<String> perks, String extraInfo, String checkIn, String checkOut, int guests, User owner, Set<AccommodationImage> accommodationImages) {
        this.title = title;
        this.address = address;
        this.description = description;
        this.perks = perks;
        this.extraInfo = extraInfo;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.guests = guests;
        this.owner = owner;
        this.accommodationImages = accommodationImages;
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

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public int getGuests() {
        return guests;
    }

    public void setGuests(int guests) {
        this.guests = guests;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Set<AccommodationImage> getAccommodationImages() {
        return accommodationImages;
    }

    public void setAccommodationImages(Set<AccommodationImage> accommodationImages) {
        this.accommodationImages = accommodationImages;
    }
}
