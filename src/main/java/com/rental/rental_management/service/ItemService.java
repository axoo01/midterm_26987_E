package com.rental.rental_management.service;

import com.rental.rental_management.domain.Item;
import com.rental.rental_management.repository.ItemRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepo;

    public String saveItem(Item item){

        Boolean checkItem = itemRepo.existsByCode(item.getCode());

        if(checkItem){
            return "Item with this code already exists.";
        }

        if(item.getQuantity() < 0){
            return "Quantity cannot be negative.";
        }

        itemRepo.save(item);

        return "Item saved successfully.";
    }
    public List<Item> getAllItems(){
        return itemRepo.findAll();
    }

}