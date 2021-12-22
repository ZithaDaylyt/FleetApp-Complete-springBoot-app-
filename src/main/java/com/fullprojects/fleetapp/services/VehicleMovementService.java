package com.fullprojects.fleetapp.services;

import com.fullprojects.fleetapp.models.JobTitle;
import com.fullprojects.fleetapp.models.VehicleMovement;
import com.fullprojects.fleetapp.repositories.JobTitleRepository;
import com.fullprojects.fleetapp.repositories.VehicleMovementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMovementService {
    @Autowired
    private VehicleMovementRepository vehicleMovementRepository;

    //Return List of countries
    public List<VehicleMovement> getVehicleMovements(){
        return vehicleMovementRepository.findAll();
    };

    //add/save Countries to database
    public void save( VehicleMovement vehicleMovement){
        vehicleMovementRepository.save(vehicleMovement);
    }

    //get by id
    public Optional<VehicleMovement> findById(int id){
        return vehicleMovementRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleMovementRepository.deleteById(id);
    }


}
