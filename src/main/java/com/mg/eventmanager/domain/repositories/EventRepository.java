package com.mg.eventmanager.domain.repositories;

import com.mg.eventmanager.domain.Event;
import com.mg.eventmanager.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.LocalDate;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource(path="events")
public interface EventRepository extends CrudRepository<Event, Long> {
    Event findByName(String name);
}
