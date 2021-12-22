package com.fullprojects.fleetapp.repositories;

import com.fullprojects.fleetapp.models.JobTitle;
import com.fullprojects.fleetapp.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    User findByFirstnameAndLastname(String firstname, String lastname);
}
