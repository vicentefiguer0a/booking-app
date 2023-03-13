package com.example.bookingserver.controllers;

import com.example.bookingserver.models.Accommodation;
import com.example.bookingserver.models.AccommodationImage;
import com.example.bookingserver.services.accommodation.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Set;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "http://localhost:5173")
public class AccommodationController {

    private AccommodationService accommodationService;

    @Autowired
    public AccommodationController(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @PostMapping(value = "/accommodation/add", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public ResponseEntity<Accommodation> addAccommodation(@RequestPart("accommodation") Accommodation accommodation, @RequestPart("imageFile")MultipartFile[] files) {
        try {
            Set<AccommodationImage> images = accommodationService.uploadImages(files);
            accommodation.setAccommodationImages(images);
            accommodationService.saveAccommodation(accommodation);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
