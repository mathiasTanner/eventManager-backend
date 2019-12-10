package com.mg.eventmanager.repositories;

import com.mg.eventmanager.domain.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:19001")
@RepositoryRestResource(path="events")
public interface EventRepository extends CrudRepository<Event, Long> {
    @RestResource(path = "name")
    Event findByName(String name);
}
