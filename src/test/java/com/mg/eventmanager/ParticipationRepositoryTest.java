package com.mg.eventmanager;

import com.mg.eventmanager.domain.*;
import com.mg.eventmanager.domain.repositories.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EventmanagerApplication.class)
@DataJpaTest
public class ParticipationRepositoryTest {
    private Location location;
    private Admin admin;
    private Member member;
    private Event event;
    private Participation participation;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    AdminRepository adminRepository;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    ParticipationRepository participationRepository;

    @Test
    public void createNewParticipationTest(){
        emptyRepo();
        location = new Location("test",60.202589, 24.934024);
        locationRepository.save(location);

        admin = new Admin( "adm", "mail5",  true, "password");
        adminRepository.save(admin);

        member = new Member("usr", "userMail", false, "12345678");
        memberRepository.save(member);

        event = new Event("evt", LocalDate.of(2020,10,10), LocalDate.now(), location, "matos", 5, 2, admin);
        eventRepository.save(event);

        participation = new Participation(member, event);
        participationRepository.save(participation);

        List<Participation> lst = (List<Participation>) participationRepository.findAll();
        assertFalse(lst.size()== 0);
        assertFalse(participation.getPartId()==null);
    }

    @Test
    public void findParticipationTest(){
        List<Participation> lst = participationRepository.findByEvent(event.getId());
        assertEquals(1, lst.size());
        lst = participationRepository.findByMember(member.getId());
        assertEquals(1, lst.size());
    }

    @Test
    public void deleteEventTest(){
        participationRepository.deleteById(participation.getPartId());
        assertThat(participationRepository.findById(participation.getPartId())).isEmpty();
    }

    @AfterAll
    public void emptyRepo(){
        eventRepository.deleteAll();
        locationRepository.deleteAll();
        adminRepository.deleteAll();
        participationRepository.deleteAll();
        memberRepository.deleteAll();
    }
}
