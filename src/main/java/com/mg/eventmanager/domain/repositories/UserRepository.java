package com.mg.eventmanager.domain.repositories;


import com.mg.eventmanager.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource(path="users")
public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
    User findByMail(String mail);
}
