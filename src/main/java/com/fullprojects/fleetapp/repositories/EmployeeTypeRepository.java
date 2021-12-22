package com.fullprojects.fleetapp.repositories;

import com.fullprojects.fleetapp.models.EmployeeType;
import com.fullprojects.fleetapp.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeTypeRepository extends JpaRepository<EmployeeType, Integer> {
}
