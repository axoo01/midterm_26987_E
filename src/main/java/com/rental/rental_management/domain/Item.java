package com.rental.rental_management.domain;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID itemId;

    @Column(unique = true)
    private String code;

    private String name;

    private double price;

    private Integer quantity;

    public Item() {
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }    

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }    

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
