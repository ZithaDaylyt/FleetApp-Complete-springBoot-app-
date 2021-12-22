package com.fullprojects.fleetapp.services;

import com.fullprojects.fleetapp.models.Contact;
import com.fullprojects.fleetapp.models.Location;
import com.fullprojects.fleetapp.repositories.ContactRepository;
import com.fullprojects.fleetapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    //Return List of countries
    public List<Contact> getContacts(){
        return contactRepository.findAll();
    };

    //add/save Countries to database
    public void save( Contact contact){
        contactRepository.save(contact);
    }

    //get by id
    public Optional<Contact> findById(int id){
        return contactRepository.findById(id);
    }

    public void delete(Integer id) {
        contactRepository.deleteById(id);
    }


}
