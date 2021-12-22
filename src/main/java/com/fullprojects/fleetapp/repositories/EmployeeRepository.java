package com.fullprojects.fleetapp.repositories;

import com.fullprojects.fleetapp.models.Employee;
import com.fullprojects.fleetapp.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByUsername(String un);
}
