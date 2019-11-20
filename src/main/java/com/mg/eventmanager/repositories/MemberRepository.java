package com.mg.eventmanager.repositories;


import com.mg.eventmanager.domain.Member;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RepositoryRestResource(path="members")
public interface MemberRepository extends CrudRepository<Member, Long> {
    Member findByUsername(String username);
    Member findByMail(String mail);

    @Query(value = "SELECT u FROM evt_member u where u.userName = ?1 and u.password = ?2 ")
    Optional<Member> login(String username, String password);
    Optional<Member> findByToken(String token);
}
