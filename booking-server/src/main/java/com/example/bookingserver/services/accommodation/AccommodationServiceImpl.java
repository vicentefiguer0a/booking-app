package com.example.bookingserver.services.accommodation;

import com.example.bookingserver.models.Accommodation;
import com.example.bookingserver.models.AccommodationImage;
import com.example.bookingserver.repository.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private AccommodationRepository accommodationRepository;

    @Autowired
    public AccommodationServiceImpl(AccommodationRepository accommodationRepository) {
        this.accommodationRepository = accommodationRepository;
    }

    @Override
    public Accommodation saveAccommodation(Accommodation accommodation) {
        Accommodation accommodationToSave = new Accommodation();
        accommodationToSave.setTitle(accommodation.getTitle());
        accommodationToSave.setAddress(accommodation.getAddress());
        // TODO: Save accommodation photos to db.
        accommodationToSave.setDescription(accommodation.getDescription());
        accommodationToSave.setPerks(accommodation.getPerks());
        accommodationToSave.setExtraInfo(accommodation.getExtraInfo());
        accommodationToSave.setCheckIn(accommodation.getCheckIn());
        accommodationToSave.setCheckOut(accommodation.getCheckOut());
        accommodationToSave.setGuests(accommodation.getGuests());
        // TODO: Create user object to save with accommodation object, with user id attached to request.
        return accommodationRepository.save(accommodationToSave);
    }

    @Override
    public Set<AccommodationImage> uploadImages(MultipartFile[] multipartFiles) throws IOException {
        Set<AccommodationImage> accommodationImages = new HashSet<>();
        for (MultipartFile file: multipartFiles) {
            // Creating new AccommodationImage object.
            AccommodationImage accommodationImage = new AccommodationImage(
                    file.getOriginalFilename(),
                    file.getContentType(),
                    file.getBytes()
            );
            accommodationImages.add(accommodationImage);
        }
        return accommodationImages;
    }
}
