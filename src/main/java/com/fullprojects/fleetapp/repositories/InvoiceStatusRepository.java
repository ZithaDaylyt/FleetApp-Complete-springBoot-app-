package com.fullprojects.fleetapp.repositories;

import com.fullprojects.fleetapp.models.InvoiceStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceStatusRepository extends JpaRepository<InvoiceStatus, Integer> {
}
