package com.mg.eventmanager.domain.repositories;

import com.mg.eventmanager.domain.Event;
import com.mg.eventmanager.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@RepositoryRestResource(path="events")
public interface EventRepository extends CrudRepository<Event, Long> {
    List<Event> findByName(String name);
}
