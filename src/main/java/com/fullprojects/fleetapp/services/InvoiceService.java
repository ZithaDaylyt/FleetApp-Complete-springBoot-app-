package com.fullprojects.fleetapp.services;

import com.fullprojects.fleetapp.models.Invoice;
import com.fullprojects.fleetapp.models.State;
import com.fullprojects.fleetapp.repositories.InvoiceRepository;
import com.fullprojects.fleetapp.repositories.StateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    //Return List of countries
    public List<Invoice> getInvoices(){
        return invoiceRepository.findAll();
    };

    //add/save Countries to database
    public void save(Invoice invoice){
        invoiceRepository.save(invoice);
    }

    //get by id
    public Optional<Invoice> findById(int id){
        return invoiceRepository.findById(id);
    }

    public void delete(Integer id) {
        invoiceRepository.deleteById(id);
    }
}
