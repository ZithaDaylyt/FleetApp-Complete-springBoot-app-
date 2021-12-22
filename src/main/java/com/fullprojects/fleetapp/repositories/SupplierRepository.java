package com.fullprojects.fleetapp.repositories;

import com.fullprojects.fleetapp.models.Location;
import com.fullprojects.fleetapp.models.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
}
