package com.fullprojects.fleetapp.services;

import com.fullprojects.fleetapp.models.Location;
import com.fullprojects.fleetapp.models.VehicleMake;
import com.fullprojects.fleetapp.repositories.LocationRepository;
import com.fullprojects.fleetapp.repositories.VehicleMakeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMakeService {

    @Autowired
    private VehicleMakeRepository vehicleMakeRepository;

    //Return List of countries
    public List<VehicleMake> getVehicleMakes(){
        return vehicleMakeRepository.findAll();
    };

    //add/save Countries to database
    public void save( VehicleMake vehicleMake){
        vehicleMakeRepository.save(vehicleMake);
    }

    //get by id
    public Optional<VehicleMake> findById(int id){
        return vehicleMakeRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleMakeRepository.deleteById(id);
    }


}
