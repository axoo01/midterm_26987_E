package com.rental.rental_management.repository;

import com.rental.rental_management.domain.CustomerProfile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, UUID> {

    Boolean existsByNationalId(String nationalId);

}
