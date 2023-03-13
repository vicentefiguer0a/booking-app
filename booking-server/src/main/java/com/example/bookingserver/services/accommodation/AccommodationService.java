package com.example.bookingserver.services.accommodation;

import com.example.bookingserver.models.Accommodation;
import com.example.bookingserver.models.AccommodationImage;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Set;

public interface AccommodationService {
    Accommodation saveAccommodation(Accommodation accommodation);
    Set<AccommodationImage> uploadImages(MultipartFile[] multipartFiles) throws IOException;
}
