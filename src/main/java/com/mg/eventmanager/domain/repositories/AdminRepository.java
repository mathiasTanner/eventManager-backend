package com.mg.eventmanager.domain.repositories;

import com.mg.eventmanager.domain.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path="admin")
public interface AdminRepository extends CrudRepository<Admin, Long> {
}
