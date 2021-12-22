package com.fullprojects.fleetapp.services;

import com.fullprojects.fleetapp.models.Country;
import com.fullprojects.fleetapp.models.State;
import com.fullprojects.fleetapp.repositories.CountryRepository;
import com.fullprojects.fleetapp.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StateService {

    @Autowired
    private StateRepository stateRepository;

    //Return List of countries
    public List<State> getStates(){
        return stateRepository.findAll();
    };

    //add/save Countries to database
    public void save( State state){
        stateRepository.save(state);
    }

    //get by id
    public Optional<State> findById(int id){
        return stateRepository.findById(id);
    }

    public void delete(Integer id) {
        stateRepository.deleteById(id);
    }
}
