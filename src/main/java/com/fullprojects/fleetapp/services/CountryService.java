package com.fullprojects.fleetapp.services;

import com.fullprojects.fleetapp.models.Country;
import com.fullprojects.fleetapp.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    //Return List of countries
    public List<Country> getCountries(){
        return countryRepository.findAll();
    };

    //add/save Countries to database
    public void save( Country country){
        countryRepository.save(country);
    }

    //get by id
    public Optional<Country> findById(int id){
        return countryRepository.findById(id);
    }

    public void delete(Integer id) {
        countryRepository.deleteById(id);
    }
}
