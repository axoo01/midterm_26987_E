package com.rental.rental_management.domain;

import jakarta.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "location")
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID locationId;

    @Column(unique = true)
    private String code;

    private String name;

    @Enumerated(EnumType.STRING)
    private ELocationType type;

    @ManyToOne
    @JoinColumn(name = "parent_id")
    private Location parent;

    public Location() {}

    public UUID getLocationId() {
        return locationId;
    }

    public void setLocationId(UUID locationId) {
        this.locationId = locationId;
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

    public ELocationType getType() {
        return type;
    }

    public void setType(ELocationType type) {
        this.type = type;
    }

    public Location getParent() {
        return parent;
    }

    public void setParent(Location parent) {
        this.parent = parent;
    }
}