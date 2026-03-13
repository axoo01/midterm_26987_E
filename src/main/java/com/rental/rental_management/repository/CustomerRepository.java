package com.rental.rental_management.repository;

import com.rental.rental_management.domain.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, UUID> {

    Boolean existsByEmail(String email);

    List<Customer> findByLocationParentParentParentParentCode(String code);

    List<Customer> findByLocationParentParentParentParentName(String name);
}