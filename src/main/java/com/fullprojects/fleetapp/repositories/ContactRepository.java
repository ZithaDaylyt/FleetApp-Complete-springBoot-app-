package com.fullprojects.fleetapp.repositories;

import com.fullprojects.fleetapp.models.Client;
import com.fullprojects.fleetapp.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer> {
}
