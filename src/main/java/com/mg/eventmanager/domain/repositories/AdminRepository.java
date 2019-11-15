package com.mg.eventmanager.domain.repositories;

import com.mg.eventmanager.domain.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource(path="admins")
public interface AdminRepository extends CrudRepository<Admin, Long> {
    Admin findByUsername(String username);
}
