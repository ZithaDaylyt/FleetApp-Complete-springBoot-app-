package com.fullprojects.fleetapp.services;

import com.fullprojects.fleetapp.models.Location;
import com.fullprojects.fleetapp.models.VehicleMaintenance;
import com.fullprojects.fleetapp.repositories.LocationRepository;
import com.fullprojects.fleetapp.repositories.VehicleMaintenanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleMaintenaceService {

    @Autowired
    private VehicleMaintenanceRepository vehicleMaintenanceRepository;

    //Return List of countries
    public List<VehicleMaintenance> getVehicleMaintenance(){
        return vehicleMaintenanceRepository.findAll();
    };

    //add/save Countries to database
    public void save( VehicleMaintenance vehicleMaintenance){
        vehicleMaintenanceRepository.save(vehicleMaintenance);
    }

    //get by id
    public Optional<VehicleMaintenance> findById(int id){
        return vehicleMaintenanceRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleMaintenanceRepository.deleteById(id);
    }


}
