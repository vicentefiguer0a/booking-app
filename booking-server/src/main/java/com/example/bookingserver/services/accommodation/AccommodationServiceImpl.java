package com.example.bookingserver.services.accommodation;

import com.example.bookingserver.models.Accommodation;
import com.example.bookingserver.repository.AccommodationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
