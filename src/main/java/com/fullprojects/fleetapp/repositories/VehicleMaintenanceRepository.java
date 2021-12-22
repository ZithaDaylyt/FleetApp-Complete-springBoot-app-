package com.fullprojects.fleetapp.repositories;

import com.fullprojects.fleetapp.models.Location;
import com.fullprojects.fleetapp.models.VehicleMaintenance;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleMaintenanceRepository extends JpaRepository<VehicleMaintenance, Integer> {
}
