package com.fullprojects.fleetapp.services;

import com.fullprojects.fleetapp.models.Employee;
import com.fullprojects.fleetapp.models.Location;
import com.fullprojects.fleetapp.models.User;
import com.fullprojects.fleetapp.repositories.EmployeeRepository;
import com.fullprojects.fleetapp.repositories.LocationRepository;
import com.fullprojects.fleetapp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private UserRepository userRepository;

    //Return List of countries
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    };

    //add/save Countries to database
    public void save( Employee employee){
        employeeRepository.save(employee);
    }

    //get by id
    public Optional<Employee> findById(int id){
        return employeeRepository.findById(id);
    }

    public void delete(Integer id) {
        employeeRepository.deleteById(id);
    }

    public Employee findByUsername(String un){
        return employeeRepository.findByUsername(un);
    }

    public void assignUsername(int id){
        Employee employee = employeeRepository.findById(id).orElse(null);
        User user = userRepository.findByFirstnameAndLastname(

                employee.getFirstname(),
                employee.getLastname());
        employee.setUsername(user.getUsername());
        employeeRepository.save(employee);
    }
}
