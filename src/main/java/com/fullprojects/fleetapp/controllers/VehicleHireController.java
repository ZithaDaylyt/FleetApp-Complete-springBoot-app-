package com.fullprojects.fleetapp.controllers;


import com.fullprojects.fleetapp.models.VehicleHire;
import com.fullprojects.fleetapp.models.VehicleMovement;
import com.fullprojects.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleHireController {

    @Autowired
    private VehicleHireService vehicleHireService;
    @Autowired
    private LocationService locationService;
    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private ClientService clientService;


    @GetMapping("/vehicleHires")
    public String getStates( Model model ){
        List<VehicleHire> vehicleHireList  =  vehicleHireService.getVehicleHires();

        model.addAttribute("vehicleHires", vehicleHireList);
        model.addAttribute("locations", locationService.getLocations());
        model.addAttribute("vehicles", vehicleService.getVehicles());
        model.addAttribute("clients", clientService.getClients());
        return "vehicleHire";
    }

    @PostMapping("/vehicleHires/addNew")
    public String addNew(VehicleHire vehicleHire){
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHires";
    }

    @RequestMapping(value = "/vehicleHires/findById")
    @ResponseBody
    public Optional<VehicleHire> findById(int id){
        return vehicleHireService.findById(id);
    }

    @RequestMapping( value = "/vehicleHires/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleHire vehicleHire){
        vehicleHireService.save(vehicleHire);
        return "redirect:/vehicleHires";
    }

    @RequestMapping( value = "/vehicleHires/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleHireService.delete(id);
        return "redirect:/vehicleHires";
    }



}
