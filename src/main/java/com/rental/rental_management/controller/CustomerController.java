package com.rental.rental_management.controller;

import com.rental.rental_management.domain.Customer;
import com.rental.rental_management.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping(
        value = "/save",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> saveCustomer(
            @RequestBody Customer customer,
            @RequestParam String locationId){

        String response = customerService.saveCustomer(customer, locationId);

        if(response.equals("Customer saved successfully.")){
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/province/code/{code}")
    public ResponseEntity<?> getCustomersByProvinceCode(@PathVariable String code){
        return new ResponseEntity<>(customerService.getCustomersByProvinceCode(code), HttpStatus.OK);
    }

    @GetMapping("/province/name/{name}")
    public ResponseEntity<?> getCustomersByProvinceName(@PathVariable String name){
        return new ResponseEntity<>(customerService.getCustomersByProvinceName(name), HttpStatus.OK);
    }

    @GetMapping("/paged")
    public ResponseEntity<Page<Customer>> getCustomersPaged(Pageable pageable){
        return new ResponseEntity<>(customerService.getCustomersPaged(pageable), HttpStatus.OK);
    }
}