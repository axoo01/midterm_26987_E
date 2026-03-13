package com.rental.rental_management.service;

import com.rental.rental_management.domain.Customer;
import com.rental.rental_management.domain.CustomerProfile;
import com.rental.rental_management.repository.CustomerProfileRepository;
import com.rental.rental_management.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class CustomerProfileService {

    @Autowired
    private CustomerProfileRepository profileRepo;

    @Autowired
    private CustomerRepository customerRepo;

    public String saveProfile(CustomerProfile profile, String customerId){

        if(profileRepo.existsByNationalId(profile.getNationalId())){
            return "Profile with this national ID already exists.";
        }

        Customer customer = customerRepo.findById(UUID.fromString(customerId)).orElse(null);

        if(customer == null){
            return "Customer not found.";
        }

        profile.setCustomer(customer);

        profileRepo.save(profile);

        return "Customer profile saved successfully.";
    }

}