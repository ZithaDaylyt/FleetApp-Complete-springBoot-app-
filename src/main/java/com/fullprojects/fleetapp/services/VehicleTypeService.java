package com.fullprojects.fleetapp.services;

import com.fullprojects.fleetapp.models.Location;
import com.fullprojects.fleetapp.models.VehicleType;
import com.fullprojects.fleetapp.repositories.LocationRepository;
import com.fullprojects.fleetapp.repositories.VehicleTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleTypeService {
    @Autowired
    private VehicleTypeRepository vehicleTypeRepository;

    //Return List of countries
    public List<VehicleType> getVehicleTypes(){
        return vehicleTypeRepository.findAll();
    };

    //add/save Countries to database
    public void save( VehicleType vehicleType){
        vehicleTypeRepository.save(vehicleType);
    }

    //get by id
    public Optional<VehicleType> findById(int id){
        return vehicleTypeRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleTypeRepository.deleteById(id);
    }


}
