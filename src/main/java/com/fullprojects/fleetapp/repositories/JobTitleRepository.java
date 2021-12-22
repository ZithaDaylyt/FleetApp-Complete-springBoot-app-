package com.fullprojects.fleetapp.repositories;

import com.fullprojects.fleetapp.models.JobTitle;
import com.fullprojects.fleetapp.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobTitleRepository extends JpaRepository<JobTitle, Integer> {
}
