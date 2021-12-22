package com.fullprojects.fleetapp.controllers;


import com.fullprojects.fleetapp.models.VehicleMaintenance;
import com.fullprojects.fleetapp.models.VehicleMovement;
import com.fullprojects.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMovementController {

    @Autowired
    private VehicleService vehicleService ;
    @Autowired
    private LocationService locationService;
    @Autowired
    private VehicleMovementService vehicleMovementService;

    @GetMapping("/vehicleMovements")
    public String getStates( Model model ){
        List<VehicleMovement> vehicleMovementList  =  vehicleMovementService.getVehicleMovements();

        model.addAttribute("vehicleMovements", vehicleMovementList);
        model.addAttribute("locations", locationService.getLocations());
        model.addAttribute("vehicles",vehicleService.getVehicles());
        return "vehicleMovement";
    }

    @PostMapping("/vehicleMovements/addNew")
    public String addNew(VehicleMovement vehicleMovement){
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovements";
    }

    @RequestMapping(value = "/vehicleMovements/findById")
    @ResponseBody
    public Optional<VehicleMovement> findById(int id){
        return vehicleMovementService.findById(id);
    }

    @RequestMapping( value = "/vehicleMovements/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMovement vehicleMovement){
        vehicleMovementService.save(vehicleMovement);
        return "redirect:/vehicleMovements";
    }

    @RequestMapping( value = "/vehicleMovements/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleMovementService.delete(id);
        return "redirect:/vehicleMovements";
    }


}
