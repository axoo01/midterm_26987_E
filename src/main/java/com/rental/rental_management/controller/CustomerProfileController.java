package com.rental.rental_management.controller;

import com.rental.rental_management.domain.CustomerProfile;
import com.rental.rental_management.service.CustomerProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/profiles")
public class CustomerProfileController {

    @Autowired
    private CustomerProfileService profileService;

    @PostMapping(
        value = "/save",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> saveProfile(
            @RequestBody CustomerProfile profile,
            @RequestParam String customerId){

        String response = profileService.saveProfile(profile, customerId);

        if(response.equals("Customer profile saved successfully.")){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    
}