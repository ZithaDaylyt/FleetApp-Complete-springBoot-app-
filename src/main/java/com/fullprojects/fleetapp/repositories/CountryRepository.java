package com.fullprojects.fleetapp.repositories;

import com.fullprojects.fleetapp.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {
}
