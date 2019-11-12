package com.mg.eventmanager.domain.repositories;


import com.mg.eventmanager.domain.Location;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="locations")
public interface LocationRepository extends CrudRepository<Location, Long> {
}
