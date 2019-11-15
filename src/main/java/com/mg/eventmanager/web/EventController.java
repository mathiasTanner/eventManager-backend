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
    private EventRepository repo;

    @RequestMapping(value="/events", method = RequestMethod.GET)
    public @ResponseBody List<Event> findAllEvents() {
        return (List<Event>)repo.findAll();
    }

    @RequestMapping(value="/events/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Event> findEvent(@PathVariable("id") Long id) {
        return repo.findById(id);
    }

    @RequestMapping(value = "/events/save", method = RequestMethod.POST)
    public void saveEvent(Event event){
        repo.save(event);
    }

    @RequestMapping(value="events/delete/{id}", method = RequestMethod.GET)
    public void deleteEvent(@PathVariable("id") Long id){
        repo.deleteById(id);
    }

}
