package com.rental.rental_management.service;

import com.rental.rental_management.domain.Customer;
import com.rental.rental_management.domain.Item;
import com.rental.rental_management.domain.Rental;
import com.rental.rental_management.repository.CustomerRepository;
import com.rental.rental_management.repository.ItemRepository;
import com.rental.rental_management.repository.RentalRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class RentalService {

    @Autowired
    private RentalRepository rentalRepo;

    @Autowired
    private CustomerRepository customerRepo;

    @Autowired
    private ItemRepository itemRepo;

    public String createRental(Rental rental, String customerId, String itemId){

        // check if customer exists
        Customer customer = customerRepo.findById(UUID.fromString(customerId)).orElse(null);

        if(customer == null){
            return "Customer not found.";
        }

        // check if item exists
        Item item = itemRepo.findById(UUID.fromString(itemId)).orElse(null);

        if(item == null){
            return "Item not found.";
        }

        // check if item is available
        if(item.getQuantity() <= 0){
            return "Item is not available for rental.";
        }

        // assign customer and item
        rental.setCustomer(customer);
        rental.setItem(item);

        // reduce item quantity
        item.setQuantity(item.getQuantity() - 1);
        itemRepo.save(item);

        // save rental record
        rentalRepo.save(rental);

        return "Rental created successfully.";
    }

}