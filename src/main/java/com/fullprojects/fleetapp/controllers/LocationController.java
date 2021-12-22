package com.fullprojects.fleetapp.controllers;


import com.fullprojects.fleetapp.models.Country;
import com.fullprojects.fleetapp.models.Invoice;
import com.fullprojects.fleetapp.models.Location;
import com.fullprojects.fleetapp.models.State;
import com.fullprojects.fleetapp.services.CountryService;
import com.fullprojects.fleetapp.services.LocationService;
import com.fullprojects.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class LocationController {

    @Autowired private StateService stateService;
    @Autowired private CountryService countryService;
    @Autowired private LocationService locationService;

    @GetMapping("/locations")
    public String getLocation(Model model){
        List<State> stateList = stateService.getStates();
        List<Country> countryList = countryService.getCountries();
        List<Location> locationList = locationService.getLocations();

        model.addAttribute("countries", countryList);
        model.addAttribute("states", stateList);
        model.addAttribute("locations", locationList);

        return "location";
    }

    @PostMapping("/locations/addNew")
    public String addNew(Location location){
        locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping(value = "/locations/findById")
    @ResponseBody
    public Optional<Location> findById(int id){
        return locationService.findById(id);
    }

    @RequestMapping( value = "/locations/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Location location){
       locationService.save(location);
        return "redirect:/locations";
    }

    @RequestMapping( value = "/locations/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        locationService.delete(id);
        return "redirect:/locations";
    }
}
