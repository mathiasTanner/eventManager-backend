package com.mg.eventmanager;

import com.mg.eventmanager.web.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class EventmanagerApplicationTests {

    @Autowired
    AdminController adminController;

    @Autowired
    EventController eventController;

    @Autowired
    LocationController locationController;

    @Autowired
    ParticipationController participationController;

    @Autowired
    UserController userController;

    @Test
    void contextLoads() {
        assertThat(adminController).isNotNull();
        assertThat(eventController).isNotNull();
        assertThat(locationController).isNotNull();
        assertThat(participationController).isNotNull();
        assertThat(userController).isNotNull();
    }

}
