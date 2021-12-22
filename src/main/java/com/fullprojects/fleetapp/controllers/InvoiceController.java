package com.fullprojects.fleetapp.controllers;



import com.fullprojects.fleetapp.models.Invoice;

import com.fullprojects.fleetapp.services.ClientService;
import com.fullprojects.fleetapp.services.CountryService;
import com.fullprojects.fleetapp.services.InvoiceService;
import com.fullprojects.fleetapp.services.InvoiceStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceController {
    @Autowired
    private InvoiceService invoiceService;
    @Autowired
    private ClientService clientService;
    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @GetMapping("/invoices")
    public String getInvoices( Model model ){
        List<Invoice> invoiceList  = invoiceService.getInvoices();

        model.addAttribute("clients", clientService.getClients());
        model.addAttribute("Invoices", invoiceList);
        model.addAttribute("invoiceStatuses", invoiceStatusService.getInvoiceStatuses());
        return "invoice";
    }

    @PostMapping("/invoices/addNew")
    public String addNew(Invoice invoice){
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping(value = "/invoices/findById")
    @ResponseBody
    public Optional<Invoice> findById(int id){
        return invoiceService.findById(id);
    }

    @RequestMapping( value = "/invoices/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(Invoice invoice){
        invoiceService.save(invoice);
        return "redirect:/invoices";
    }

    @RequestMapping( value = "/invoice/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        invoiceService.delete(id);
        return "redirect:/invoices";
    }

}
