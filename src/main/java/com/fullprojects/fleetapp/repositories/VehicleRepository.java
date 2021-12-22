package com.fullprojects.fleetapp.repositories;

import com.fullprojects.fleetapp.models.Location;
import com.fullprojects.fleetapp.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {
}
