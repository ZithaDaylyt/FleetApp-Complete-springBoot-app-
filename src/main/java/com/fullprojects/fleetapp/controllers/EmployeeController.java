package com.fullprojects.fleetapp.controllers;


import com.fullprojects.fleetapp.models.Employee;
import com.fullprojects.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    private StateService stateService;
    @Autowired
    private JobTitleService jobTitleService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private VehicleTypeService vehicleTypeService;
    @Autowired
    private EmployeeTypeService employeeTypeService;



    @GetMapping("/employees")
    public String getEmployees( Model model ){
        List<Employee> employeeList =employeeService.getEmployees();

        model.addAttribute("jobTitles", jobTitleService.getJobTitles());
        model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleTypes());
        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.getStates());
        model.addAttribute("employeeTypes", employeeTypeService.getEmployeeTypes());
        model.addAttribute("employees",employeeService.getEmployees());

        //model.addAttribute("vehicles", vehicleList);
        return "employee";
    }

    @PostMapping("/employees/addNew")
    public String addNew(Employee employee){
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/findById")
    @ResponseBody
    public Optional<Employee> findById(int id){
        return employeeService.findById(id);
    }

    @RequestMapping( value = "/employees/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Employee employee){
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @RequestMapping( value = "/employees/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        employeeService.delete(id);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees/assignUsername")
    public String assignUsername(int id){
        employeeService.assignUsername(id);
        return "redirect:/employees";
    }

}
