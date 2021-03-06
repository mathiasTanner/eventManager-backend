package com.mg.eventmanager.services;

import com.mg.eventmanager.domain.Member;
import com.mg.eventmanager.repositories.MemberRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import java.util.Optional;
import java.util.UUID;

@Service("MemberService")
public class DefaultMemberService implements MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Override
    public String login(String username, String password) {
        Optional<Member> member = memberRepository.login(username,password);
        if(member.isPresent()){
            String token = UUID.randomUUID().toString();
            Member memb= member.get();
            memb.setToken(token);
            memberRepository.save(memb);
            return token;
        }

        return StringUtils.EMPTY;
    }

    @Override
    public Optional<User> findByToken(String token) {
        Optional<Member> member= memberRepository.findByToken(token);
        if(member.isPresent()){
            Member member1 = member.get();
            User user= new User(member1.getUsername(), member1.getPasswordHash(), true, true, true, true,
                    AuthorityUtils.createAuthorityList("USER"));
            return Optional.of(user);
        }
        return  Optional.empty();
    }

    @Override
    public Member findById(Long id) {
        Optional<Member> member = memberRepository.findById(id);
        return member.orElse(null);
    }

    @Override
    public Member register(Member member){
        Member memb = memberRepository.save(member);
        return memb;
    }
}
