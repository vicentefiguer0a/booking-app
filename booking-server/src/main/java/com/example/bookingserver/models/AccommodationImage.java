package com.example.bookingserver.models;

import jakarta.persistence.*;

@Entity
@Table(name = "accommodation_images")
public class AccommodationImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;

    @Column(name = "image", unique = false, nullable = false, length = 5000000)
    private byte[] image;

    @ManyToOne(fetch = FetchType.LAZY)
    private Accommodation accommodation;

    // Constructor
    public AccommodationImage() {}

    public AccommodationImage(String name, String type, byte[] image) {
        this.name = name;
        this.type = type;
        this.image = image;
    }

    public AccommodationImage(String name, String type, byte[] image, Accommodation accommodation) {
        this.name = name;
        this.type = type;
        this.image = image;
        this.accommodation = accommodation;
    }

    // Getters & Setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public Accommodation getAccommodation() {
        return accommodation;
    }

    public void setAccommodation(Accommodation accommodation) {
        this.accommodation = accommodation;
    }
}
