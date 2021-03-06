package com.mg.eventmanager.repositories;


import com.mg.eventmanager.domain.Participation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource(path="participations")
public interface ParticipationRepository extends CrudRepository<Participation, Long> {
    List<Participation> findByEvent(Long evtId);
    List<Participation> findByMember(Long userId);
}
