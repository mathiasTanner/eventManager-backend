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

@CrossOrigin(origins = "/**", allowedHeaders = "*")
@Controller
public class EventController {
    @Autowired
    private EventRepository repo;

    @Autowired
    private UserRepository userRepo;

    @Autowired
    private LocationRepository locRepo;

    @Autowired
    private ParticipationRepository partRepo;

    @RequestMapping(value="/event", method = RequestMethod.GET)
    public @ResponseBody List<Event> findAllEvents() {
        return (List<Event>)repo.findAll();
    }

    @RequestMapping(value="/event/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<Event> findEvent(@PathVariable("id") Long id) {
        return repo.findById(id);
    }

    @RequestMapping(value = "/event/save", method = RequestMethod.POST)
    public void saveEvent(Event event){
        repo.save(event);
    }

    @RequestMapping(value="event/delete/{id}", method = RequestMethod.GET)
    public void deleteEvent(@PathVariable("id") Long id){
        repo.deleteById(id);
    }

    /*************** get users in relation of an event *********/

    /*@RequestMapping(value="event/{id}/admin", method = RequestMethod.GET)
    public Optional<User> findCreator(@PathVariable("id") Long id){
        return userRepo.findById(repo.findById(id).get().getCreator().getId());
    }

    @RequestMapping(value="event/{id}/members", method = RequestMethod.GET)
    public List<User> findMembers(@PathVariable("id") Long id){
        Event evt = repo.findById(id).orElse(null);
        List<User> userLst = new ArrayList();
        for (User user: evt.getMemberList()){
            userLst.add(userRepo.findById(user.getId()).orElse(null));
        }
        return userLst;
    }

     */
}
