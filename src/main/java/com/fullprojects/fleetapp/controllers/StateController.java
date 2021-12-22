package com.fullprojects.fleetapp.controllers;


import com.fullprojects.fleetapp.models.State;
import com.fullprojects.fleetapp.services.CountryService;
import com.fullprojects.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class StateController {
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;

    @GetMapping("/states")
    public String getStates( Model model ){
        List<State> stateList  = stateService.getStates();

        model.addAttribute("states", stateList);
        model.addAttribute("countries",countryService.getCountries());
        return "state";
    }

    @PostMapping("/states/addNew")
    public String addNew(State state){
        stateService.save(state);
        return "redirect:/states";
    }

    @RequestMapping(value = "/states/findById")
    @ResponseBody
    public Optional<State> findById(int id){
        return stateService.findById(id);
    }

    @RequestMapping( value = "/states/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(State state){
        stateService.save(state);
        return "redirect:/states";
    }

    @RequestMapping( value = "/states/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        stateService.delete(id);
        return "redirect:/states";
    }

}
