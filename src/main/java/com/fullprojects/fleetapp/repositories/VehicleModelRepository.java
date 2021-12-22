package com.fullprojects.fleetapp.repositories;

import com.fullprojects.fleetapp.models.Location;
import com.fullprojects.fleetapp.models.VehicleModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleModelRepository extends JpaRepository<VehicleModel, Integer> {
}
