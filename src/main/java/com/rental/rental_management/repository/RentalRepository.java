package com.rental.rental_management.repository;

import com.rental.rental_management.domain.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RentalRepository extends JpaRepository<Rental, UUID> {

}
