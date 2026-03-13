package com.rental.rental_management.controller;

import com.rental.rental_management.domain.Item;
import com.rental.rental_management.service.ItemService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @PostMapping(
        value = "/save",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> saveItem(@RequestBody Item item){

        String response = itemService.saveItem(item);

        if(response.equals("Item saved successfully.")){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else{
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }

    }
    @GetMapping(
    value = "/all",
    produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> getAllItems(){

        return new ResponseEntity<>(itemService.getAllItems(), HttpStatus.OK);

    }

}
