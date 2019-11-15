package com.mg.eventmanager;

import com.mg.eventmanager.domain.Admin;
import com.mg.eventmanager.domain.Event;
import com.mg.eventmanager.domain.Location;
import com.mg.eventmanager.domain.repositories.AdminRepository;
import com.mg.eventmanager.domain.repositories.EventRepository;
import com.mg.eventmanager.domain.repositories.LocationRepository;
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
public class EventRepositoryTest {
    private Location location;
    private Admin admin;
    private Event event;

    @Autowired
    EventRepository eventRepository;

    @Autowired
    LocationRepository locationRepository;

    @Autowired
    AdminRepository adminRepository;

    @Test
    public void createNewEventTest(){
        emptyRepo();
        location = new Location("test",60.202589, 24.934024);
        locationRepository.save(location);

        admin = new Admin( "adm", "mail5",  true, "password");
        adminRepository.save(admin);

        event = new Event("evt", LocalDate.of(2020,10,10), LocalDate.now(), location, "matos", 5, 2, admin);
        eventRepository.save(event);

        List<Event> lst = (List<Event>) eventRepository.findAll();
        assertFalse(lst.size()== 0);
        assertFalse(event.getId()==null);
    }

    @Test
    public void findEventTest(){
        Event test = eventRepository.findByName("evt");
        assertEquals(event, test);
    }

    @Test
    public void deleteEventTest(){
        eventRepository.deleteById(event.getId());
        assertThat(eventRepository.findById(event.getId())).isEmpty();
    }

    @AfterAll
    public void emptyRepo(){
        eventRepository.deleteAll();
        locationRepository.deleteAll();
        adminRepository.deleteAll();
    }

}
