package com.mg.eventmanager.domain.repositories;

import com.mg.eventmanager.domain.Participation;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="participation")
public interface ParticipationRepository extends CrudRepository<Participation, Long> {

}
