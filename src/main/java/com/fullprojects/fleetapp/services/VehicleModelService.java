package com.fullprojects.fleetapp.services;

import com.fullprojects.fleetapp.models.Location;
import com.fullprojects.fleetapp.models.VehicleModel;
import com.fullprojects.fleetapp.repositories.LocationRepository;
import com.fullprojects.fleetapp.repositories.VehicleModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleModelService {
    @Autowired
    private VehicleModelRepository vehicleModelRepository;

    //Return List of countries
    public List<VehicleModel> getVehicleModels(){
        return vehicleModelRepository.findAll();
    };

    //add/save Countries to database
    public void save(VehicleModel vehicleModel){
        vehicleModelRepository.save(vehicleModel);
    }

    //get by id
    public Optional<VehicleModel> findById(int id){
        return vehicleModelRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleModelRepository.deleteById(id);
    }


}
