package com.fullprojects.fleetapp.repositories;

import com.fullprojects.fleetapp.models.State;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StateRepository extends JpaRepository<State,Integer> {
}
