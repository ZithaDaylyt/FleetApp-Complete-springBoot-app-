package com.fullprojects.fleetapp.services;

import com.fullprojects.fleetapp.models.Location;
import com.fullprojects.fleetapp.models.VehicleStatus;
import com.fullprojects.fleetapp.repositories.LocationRepository;
import com.fullprojects.fleetapp.repositories.VehicleStatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleStatusService {

    @Autowired
    private VehicleStatusRepository vehicleStatusRepository;

    //Return List of countries
    public List<VehicleStatus> getVehicleStatuses(){
        return vehicleStatusRepository.findAll();
    };

    //add/save Countries to database
    public void save( VehicleStatus vehicleStatus){
        vehicleStatusRepository.save(vehicleStatus);
    }

    //get by id
    public Optional<VehicleStatus> findById(int id){
        return vehicleStatusRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleStatusRepository.deleteById(id);
    }


}
