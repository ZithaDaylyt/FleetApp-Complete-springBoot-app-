package com.fullprojects.fleetapp.services;


import com.fullprojects.fleetapp.models.VehicleHire;

import com.fullprojects.fleetapp.repositories.VehicleHireRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehicleHireService {

    @Autowired
    private VehicleHireRepository vehicleHireRepository;

    //Return List of countries
    public List<VehicleHire> getVehicleHires(){
        return vehicleHireRepository.findAll();
    };

    //add/save Countries to database
    public void save(VehicleHire vehicleHire){
        vehicleHireRepository.save(vehicleHire);
    }

    //get by id
    public Optional<VehicleHire> findById(int id){
        return vehicleHireRepository.findById(id);
    }

    public void delete(Integer id) {
        vehicleHireRepository.deleteById(id);
    }
}
