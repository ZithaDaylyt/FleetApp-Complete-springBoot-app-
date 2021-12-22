package com.fullprojects.fleetapp.controllers;


import com.fullprojects.fleetapp.models.Client;
import com.fullprojects.fleetapp.models.Supplier;
import com.fullprojects.fleetapp.services.ClientService;
import com.fullprojects.fleetapp.services.CountryService;
import com.fullprojects.fleetapp.services.StateService;
import com.fullprojects.fleetapp.services.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class SupplierController {

    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private SupplierService supplierService;

    @GetMapping("/suppliers")
    public String getStates( Model model ){
        List<Supplier> supplierList  = supplierService.getSuppliers();

        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.getStates());
        model.addAttribute("supplier", supplierList);
        return "supplier";
    }

    @PostMapping("/suppliers/addNew")
    public String addNew(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping("suppliers/findById")
    @ResponseBody
    public Optional<Supplier> findById(int id){
        return supplierService.findById(id);
    }

    @RequestMapping( value = "/suppliers/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Supplier supplier){
        supplierService.save(supplier);
        return "redirect:/suppliers";
    }

    @RequestMapping( value = "/suppliers/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        supplierService.delete(id);
        return "redirect:/suppliers";
    }


}
