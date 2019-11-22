package com.mg.eventmanager;

import com.mg.eventmanager.domain.Location;
import com.mg.eventmanager.repositories.LocationRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = EventmanagerApplication.class)
@DataJpaTest
public class LocationRepositoryTest {

    private Location location;

    @Autowired
    LocationRepository locationRepository;

    @Test
    public void createNewLocationTest(){
        emptyRepo();
        location = new Location("test",60.202589, 24.934024);
        locationRepository.save(location);

        List<Location> lst = (List<Location>) locationRepository.findAll();
        assertFalse(lst.size()== 0);
        assertFalse(location.getLocId()==null);
    }

    @Test
    public void findLocationTest(){
        Location test = locationRepository.findByName("test");
        assertEquals(location, test);
    }

    @Test
    public void deleteLocationTest(){
        locationRepository.deleteById(location.getLocId());
        assertThat(locationRepository.findById(location.getLocId())).isEmpty();
    }

    @AfterAll
    public void emptyRepo(){
        locationRepository.deleteAll();
    }
}
