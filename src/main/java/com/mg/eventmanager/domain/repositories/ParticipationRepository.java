package com.mg.eventmanager.domain.repositories;


import com.mg.eventmanager.domain.Participation;
import com.mg.eventmanager.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource(path="participation")
public interface ParticipationRepository extends CrudRepository<Participation, Long> {
    List<Participation> findByEvent(Long evtId);
    List<Participation> findByUser(Long userId);
}
