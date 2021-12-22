package com.fullprojects.fleetapp.controllers;



import com.fullprojects.fleetapp.models.Vehicle;
import com.fullprojects.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleController {

    @Autowired
    private LocationService locationService;
    @Autowired
    private VehicleMakeService vehicleMakeService;
    @Autowired
    private VehicleModelService vehicleModelService;
    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private VehicleTypeService vehicleTypeService;
    @Autowired
    private VehicleStatusService vehicleStatusService;
    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/vehicles")
    public String getStates( Model model ){
        List<Vehicle> vehicleList  = vehicleService.getVehicles();

        model.addAttribute("locations", locationService.getLocations());
        model.addAttribute("vehicleMakes", vehicleMakeService.getVehicleMakes());
        model.addAttribute("vehicleModels",vehicleModelService.getVehicleModels());
        model.addAttribute("employees",employeeService.getEmployees());
        model.addAttribute("vehicleTypes", vehicleTypeService.getVehicleTypes());
        model.addAttribute("vehicleStatuses",vehicleStatusService.getVehicleStatuses());
        model.addAttribute("vehicles", vehicleList);
        return "vehicle";
    }

    @PostMapping("/vehicles/addNew")
    public String addNew(Vehicle vehicle){
        vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping(value = "/vehicles/findById")
    @ResponseBody
    public Optional<Vehicle> findById(int id){
        return vehicleService.findById(id);
    }

    @RequestMapping( value = "/vehicles/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Vehicle vehicle){
       vehicleService.save(vehicle);
        return "redirect:/vehicles";
    }

    @RequestMapping( value = "/vehicles/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleService.delete(id);
        return "redirect:/vehicles";
    }

}
