package com.fullprojects.fleetapp.repositories;

import com.fullprojects.fleetapp.models.Location;
import com.fullprojects.fleetapp.models.VehicleType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleTypeRepository extends JpaRepository<VehicleType, Integer> {
}
