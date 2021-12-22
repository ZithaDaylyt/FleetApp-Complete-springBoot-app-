package com.fullprojects.fleetapp.controllers;


import com.fullprojects.fleetapp.models.Client;
import com.fullprojects.fleetapp.models.Contact;
import com.fullprojects.fleetapp.services.ClientService;
import com.fullprojects.fleetapp.services.ContactService;
import com.fullprojects.fleetapp.services.CountryService;
import com.fullprojects.fleetapp.services.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ContactController {
    @Autowired
    private StateService stateService;
    @Autowired
    private CountryService countryService;
    @Autowired
    private ContactService contactService;

    @GetMapping("/contacts")
    public String getStates( Model model ){
        List<Contact> contactList  =  contactService.getContacts();

        model.addAttribute("countries", countryService.getCountries());
        model.addAttribute("states", stateService.getStates());
        model.addAttribute("contacts", contactList);
        return "contact";
    }

    @PostMapping("/contacts/addNew")
    public String addNew(Contact contact){
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping(value = "/contacts/findById")
    @ResponseBody
    public Optional<Contact> findById(int id){
        return contactService.findById(id);
    }

    @RequestMapping( value = "/contacts/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Contact contact){
        contactService.save(contact);
        return "redirect:/contacts";
    }

    @RequestMapping( value = "/contacts/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        contactService.delete(id);
        return "redirect:/contacts";
    }



}
