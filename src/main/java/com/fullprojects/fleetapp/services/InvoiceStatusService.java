package com.fullprojects.fleetapp.services;

import com.fullprojects.fleetapp.models.InvoiceStatus;
import com.fullprojects.fleetapp.models.Location;
import com.fullprojects.fleetapp.repositories.InvoiceStatusRepository;
import com.fullprojects.fleetapp.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceStatusService {
    @Autowired
    private InvoiceStatusRepository invoiceStatusRepository;

    //Return List of countries
    public List<InvoiceStatus> getInvoiceStatuses(){
        return invoiceStatusRepository.findAll();
    };

    //add/save Countries to database
    public void save(InvoiceStatus invoiceStatus){
        invoiceStatusRepository.save(invoiceStatus);
    }

    //get by id
    public Optional<InvoiceStatus> findById(int id){
        return invoiceStatusRepository.findById(id);
    }

    public void delete(Integer id) {
        invoiceStatusRepository.deleteById(id);
    }


}
