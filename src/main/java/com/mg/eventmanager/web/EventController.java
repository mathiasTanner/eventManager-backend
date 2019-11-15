package com.mg.eventmanager.web;

import com.mg.eventmanager.domain.Event;
import com.mg.eventmanager.domain.Participation;
import com.mg.eventmanager.domain.User;
import com.mg.eventmanager.domain.repositories.EventRepository;
import com.mg.eventmanager.domain.repositories.LocationRepository;
import com.mg.eventmanager.domain.repositories.ParticipationRepository;
import com.mg.eventmanager.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class EventController {

    @Autowired
    EventRepository eventRepo;

    @RequestMapping(value="/event/{name}", method = RequestMethod.GET)
    public @ResponseBody
    Event findEventByName(@PathVariable("name") String name) {
        return eventRepo.findByName(name);
    }


}
