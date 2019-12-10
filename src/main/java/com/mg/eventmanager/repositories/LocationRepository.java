package com.mg.eventmanager.repositories;


import com.mg.eventmanager.domain.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource(path="locations")
public interface LocationRepository extends CrudRepository<Location, Long> {
    @RestResource(path = "name")
    Location findByName(String name);
}
