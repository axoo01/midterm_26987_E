package com.rental.rental_management.controller;

import com.rental.rental_management.domain.Rental;
import com.rental.rental_management.service.RentalService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rentals")
public class RentalController {

    @Autowired
    private RentalService rentalService;

    @PostMapping(
        value = "/create",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> createRental(
            @RequestBody Rental rental,
            @RequestParam String customerId,
            @RequestParam String itemId){

        String response = rentalService.createRental(rental, customerId, itemId);

        if(response.equals("Rental created successfully.")){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}