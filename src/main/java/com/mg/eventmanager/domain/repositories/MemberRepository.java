package com.mg.eventmanager.domain.repositories;


import com.mg.eventmanager.domain.Member;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource(path="members")
public interface MemberRepository extends CrudRepository<Member, Long> {
    Member findByUsername(String username);
    Member findByMail(String mail);
}
