package com.fullprojects.fleetapp.controllers;


import com.fullprojects.fleetapp.models.Contact;
import com.fullprojects.fleetapp.models.VehicleMaintenance;
import com.fullprojects.fleetapp.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class VehicleMaintenanceController {
    @Autowired
    private VehicleService vehicleService ;
    @Autowired
    private SupplierService supplierService;
    @Autowired
    private VehicleMaintenaceService vehicleMaintenaceService;

    @GetMapping("/vehicleMaintenances")
    public String getStates( Model model ){
        List<VehicleMaintenance> vehicleMaintenanceList  =  vehicleMaintenaceService.getVehicleMaintenance();

        model.addAttribute("vehicleMaintenances", vehicleMaintenanceList);
        model.addAttribute("suppliers", supplierService.getSuppliers());
        model.addAttribute("vehicles",vehicleService.getVehicles());
        return "vehicleMaintenance";
    }

    @PostMapping("/vehicleMaintenances/addNew")
    public String addNew(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenaceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenances";
    }

    @RequestMapping( value = "/vehicleMaintenances/findById")
    @ResponseBody
    public Optional<VehicleMaintenance> findById(int id){
        return vehicleMaintenaceService.findById(id);
    }

    @RequestMapping( value = "/vehicleMaintenance/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(VehicleMaintenance vehicleMaintenance){
        vehicleMaintenaceService.save(vehicleMaintenance);
        return "redirect:/vehicleMaintenances";
    }

    @RequestMapping( value = "/vehicleMaintenances/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        vehicleMaintenaceService.delete(id);
        return "redirect:/vehicleMaintenances";
    }

}
