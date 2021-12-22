package com.fullprojects.fleetapp.controllers;


import com.fullprojects.fleetapp.models.Client;

import com.fullprojects.fleetapp.services.ClientService;
import com.fullprojects.fleetapp.services.CountryService;
import com.fullprojects.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ClientController {
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public String getStates( Model model ){
        List<Client> clientList  = clientService.getClients();

        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.getStates());
        model.addAttribute("clients", clientList);
        return "client";
    }

    @PostMapping("/clients/addNew")
    public String addNew(Client client){
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping( value = "/clients/findById")
    @ResponseBody
    public Optional<Client> findById(int id){
        return clientService.findById(id);
    }

    @RequestMapping( value = "/clients/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Client client){
        clientService.save(client);
        return "redirect:/clients";
    }

    @RequestMapping( value = "/client/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        clientService.delete(id);
        return "redirect:/clients";
    }


}
