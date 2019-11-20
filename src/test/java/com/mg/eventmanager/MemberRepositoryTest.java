package com.mg.eventmanager;

import com.mg.eventmanager.domain.Member;
import com.mg.eventmanager.repositories.MemberRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EventmanagerApplication.class)
@DataJpaTest
public class MemberRepositoryTest {
    private Member member;

    @Autowired
    MemberRepository memberRepository;


    @Test
    public void createNewMemberTest(){
        emptyRepo();
        member = new Member("usr", "userMail", false, "12345678");
        memberRepository.save(member);

        List<Member> lst = (List<Member>) memberRepository.findAll();
        assertFalse(lst.size()== 0);
        assertFalse(member.getId()==null);
    }

    @Test
    public void findMemberTest(){
        Member test = memberRepository.findByUsername("usr");
        assertEquals(member, test);
        test = memberRepository.findByMail("userMail");
        assertEquals(member, test);
    }

    @Test
    public void deleteMemberTest(){
        memberRepository.deleteById(member.getId());
        assertThat(memberRepository.findById(member.getId())).isEmpty();
    }

    @AfterAll
    public void emptyRepo(){
        memberRepository.deleteAll();
    }
}
