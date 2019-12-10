package com.mg.eventmanager.repositories;

import com.mg.eventmanager.domain.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource(path="admins")
public interface AdminRepository extends CrudRepository<Admin, Long> {
    @RestResource(path = "username")
    Admin findByUsername(String username);
    @RestResource(path = "mail")
    Admin findByMail(String mail);

}
