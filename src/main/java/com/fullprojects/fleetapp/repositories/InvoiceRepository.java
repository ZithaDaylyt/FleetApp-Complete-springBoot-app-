package com.fullprojects.fleetapp.repositories;

import com.fullprojects.fleetapp.models.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
}
