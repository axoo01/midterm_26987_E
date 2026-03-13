package com.rental.rental_management.service;

import com.rental.rental_management.domain.Customer;
import com.rental.rental_management.domain.ELocationType;
import com.rental.rental_management.domain.Location;
import com.rental.rental_management.repository.CustomerRepository;
import com.rental.rental_management.repository.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private LocationRepository locationRepo;

    public String saveCustomer(Customer customer, String locationId){

        Boolean checkCustomer = customerRepo.existsByEmail(customer.getEmail());
        if(checkCustomer){
            return "Customer with this email already exists.";
        }

        Location location = locationRepo.findById(UUID.fromString(locationId)).orElse(null);

        if(location == null){
            return "Location not found.";
        }

        if(location.getType() != ELocationType.VILLAGE){
            return "Customer must be linked to a Village.";
        }

        customer.setLocation(location);
        customerRepo.save(customer);

        return "Customer saved successfully.";
    }

    public List<Customer> getCustomersByProvinceCode(String code){
        return customerRepo.findByLocationParentParentParentParentCode(code);
    }

    public List<Customer> getCustomersByProvinceName(String name){
        return customerRepo.findByLocationParentParentParentParentName(name);
    }

    public Page<Customer> getCustomersPaged(Pageable pageable){
        return customerRepo.findAll(pageable);
    }
}