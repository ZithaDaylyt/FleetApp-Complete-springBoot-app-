package com.fullprojects.fleetapp.services;

import com.fullprojects.fleetapp.models.Location;
import com.fullprojects.fleetapp.models.Vehicle;
import com.fullprojects.fleetapp.repositories.LocationRepository;
import com.fullprojects.fleetapp.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    //Return List of countries
    public List<Vehicle> getVehicles(){
        return vehicleRepository.findAll();
    };

    //add/save Countries to database
    public void save( Vehicle vehicle){
        vehicleRepository.save(vehicle);
    }

    //get by id
    public Optional<Vehicle> findById(int id){
        return vehicleRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleRepository.deleteById(id);
    }


}
