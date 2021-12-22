package com.fullprojects.fleetapp.services;

import com.fullprojects.fleetapp.models.Client;
import com.fullprojects.fleetapp.models.State;
import com.fullprojects.fleetapp.repositories.ClientRepository;
import com.fullprojects.fleetapp.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {

    @Autowired
    private ClientRepository clientRepository;

    //Return List of countries
    public List<Client> getClients(){
        return clientRepository.findAll();
    };

    //add/save Countries to database
    public void save(Client client){
        clientRepository.save(client);
    }

    //get by id
    public Optional<Client> findById(int id){
        return clientRepository.findById(id);
    }

    public void delete(Integer id) {
        clientRepository.deleteById(id);
    }
}
