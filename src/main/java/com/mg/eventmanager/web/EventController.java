package com.mg.eventmanager.web;

import com.mg.eventmanager.domain.Event;
import com.mg.eventmanager.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

//@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class EventController {

    @Autowired
    EventRepository eventRepo;

    @RequestMapping(value="/event/{name}", method = RequestMethod.GET)
    public @ResponseBody
    Event findEventByName(@PathVariable("name") String name) {
        return eventRepo.findByName(name);
    }


}
