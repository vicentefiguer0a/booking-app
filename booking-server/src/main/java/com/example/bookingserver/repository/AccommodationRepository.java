package com.example.bookingserver.repository;

import com.example.bookingserver.models.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRepository extends JpaRepository<Accommodation, Long> {
}
