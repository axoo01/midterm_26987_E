package com.rental.rental_management.service;

import com.rental.rental_management.domain.ELocationType;
import com.rental.rental_management.domain.Location;
import com.rental.rental_management.repository.LocationRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public String saveLocation(Location location, String parentId){

        // check duplicate code
        Boolean exists = locationRepository.existsByCode(location.getCode());
        if(exists){
            return "Location with this code already exists.";
        }

        Location parent = null;

        if(parentId != null){
            parent = locationRepository.findById(UUID.fromString(parentId)).orElse(null);

            if(parent == null){
                return "Parent location not found.";
            }
        }

        ELocationType type = location.getType();

        // hierarchy validation

        if(type == ELocationType.PROVINCE && parent != null){
            return "Province should not have a parent.";
        }

        if(type == ELocationType.DISTRICT){
            if(parent == null || parent.getType() != ELocationType.PROVINCE){
                return "District must belong to a Province.";
            }
        }

        if(type == ELocationType.SECTOR){
            if(parent == null || parent.getType() != ELocationType.DISTRICT){
                return "Sector must belong to a District.";
            }
        }

        if(type == ELocationType.CELL){
            if(parent == null || parent.getType() != ELocationType.SECTOR){
                return "Cell must belong to a Sector.";
            }
        }

        if(type == ELocationType.VILLAGE){
            if(parent == null || parent.getType() != ELocationType.CELL){
                return "Village must belong to a Cell.";
            }
        }

        location.setParent(parent);

        locationRepository.save(location);

        return "Location saved successfully.";
    }
}