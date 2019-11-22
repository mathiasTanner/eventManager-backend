package com.mg.eventmanager.services;

import com.mg.eventmanager.domain.Member;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;

public interface MemberService {

    String login(String username, String password);
    Optional<User> findByToken(String token);
    Member findById(Long id);
    Member register(Member member);
}
