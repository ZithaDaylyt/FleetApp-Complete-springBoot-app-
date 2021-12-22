package com.fullprojects.fleetapp.services;


import com.fullprojects.fleetapp.models.Supplier;
import com.fullprojects.fleetapp.repositories.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    //Return List of countries
    public List<Supplier> getSuppliers(){
        return supplierRepository.findAll();
    };

    //add/save Countries to database
    public void save( Supplier supplier){
        supplierRepository.save(supplier);
    }

    //get by id
    public Optional<Supplier> findById(int id){
        return supplierRepository.findById(id);
    }

    public void delete(Integer id) {
        supplierRepository.deleteById(id);
    }


}
