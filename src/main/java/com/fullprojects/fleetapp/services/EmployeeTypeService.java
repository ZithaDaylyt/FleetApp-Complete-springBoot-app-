package com.fullprojects.fleetapp.services;

import com.fullprojects.fleetapp.models.EmployeeType;
import com.fullprojects.fleetapp.models.Location;
import com.fullprojects.fleetapp.repositories.EmployeeTypeRepository;
import com.fullprojects.fleetapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeTypeService {
    @Autowired
    private EmployeeTypeRepository employeeTypeRepository;

    //Return List of countries
    public List<EmployeeType> getEmployeeTypes(){
        return employeeTypeRepository.findAll();
    };

    //add/save Countries to database
    public void save(EmployeeType employeeType){
        employeeTypeRepository.save(employeeType);
    }

    //get by id
    public Optional<EmployeeType> findById(int id){
        return employeeTypeRepository.findById(id);
    }

    public void delete(Integer id) {
        employeeTypeRepository.deleteById(id);
    }


}
