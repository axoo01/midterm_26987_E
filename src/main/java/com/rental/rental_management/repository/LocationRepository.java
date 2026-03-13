package com.rental.rental_management.repository;

import com.rental.rental_management.domain.Location;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface LocationRepository extends JpaRepository<Location, UUID> {

    Boolean existsByCode(String code);

}