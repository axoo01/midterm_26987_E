package com.rental.rental_management.repository;

import com.rental.rental_management.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ItemRepository extends JpaRepository<Item, UUID> {

    Boolean existsByCode(String code);

}