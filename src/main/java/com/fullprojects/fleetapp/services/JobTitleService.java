package com.fullprojects.fleetapp.services;

import com.fullprojects.fleetapp.models.JobTitle;
import com.fullprojects.fleetapp.models.Location;
import com.fullprojects.fleetapp.repositories.JobTitleRepository;
import com.fullprojects.fleetapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JobTitleService {
    @Autowired
    private JobTitleRepository jobTitleRepository;

    //Return List of countries
    public List<JobTitle> getJobTitles(){
        return jobTitleRepository.findAll();
    };

    //add/save Countries to database
    public void save( JobTitle jobTitle){
        jobTitleRepository.save(jobTitle);
    }

    //get by id
    public Optional<JobTitle> findById(int id){
        return jobTitleRepository.findById(id);
    }

    public void delete(Integer id) {
        jobTitleRepository.deleteById(id);
    }


}
