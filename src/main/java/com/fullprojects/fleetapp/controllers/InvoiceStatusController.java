package com.fullprojects.fleetapp.controllers;


import com.fullprojects.fleetapp.models.Invoice;
import com.fullprojects.fleetapp.models.InvoiceStatus;
import com.fullprojects.fleetapp.models.Location;
import com.fullprojects.fleetapp.services.InvoiceStatusService;
import com.fullprojects.fleetapp.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class InvoiceStatusController {

    @Autowired
    private InvoiceStatusService invoiceStatusService;

    @GetMapping("/invoiceStatuses")
    public String getInvoiceStatuses(Model model){

        List<InvoiceStatus> invoiceStatusList = invoiceStatusService.getInvoiceStatuses();
        model.addAttribute("invoiceStatuses", invoiceStatusList);

        return "invoiceStatuses";
    }

    @PostMapping("/invoiceStatuses/addNew")
    public String addNew(InvoiceStatus invoiceStatus){
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoiceStatuses";
    }

    @RequestMapping(value = "/invoiceStatuses/findById")
    @ResponseBody
    public Optional<InvoiceStatus> findById(int id){
        return invoiceStatusService.findById(id);
    }

    @RequestMapping( value = "/invoiceStatuses/update", method = {RequestMethod.PUT, RequestMethod.GET})
    public String update(InvoiceStatus invoiceStatus){
        invoiceStatusService.save(invoiceStatus);
        return "redirect:/invoiceStatuses";
    }

    @RequestMapping( value = "/invoiceStatuses/delete", method = {RequestMethod.DELETE, RequestMethod.GET})
    public String delete(Integer id){
        invoiceStatusService.delete(id);
        return "redirect:/invoiceStatuses";
    }

}
