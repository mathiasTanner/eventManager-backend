package com.mg.eventmanager.web;

import com.mg.eventmanager.domain.Participation;
import com.mg.eventmanager.domain.repositories.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class ParticipationController {
    @Autowired
    ParticipationRepository partRepo;

    @RequestMapping(value="/participations/event/{eventId}", method = RequestMethod.GET)
    public @ResponseBody
    List<Participation> findByEvent(@PathVariable("eventId") Long id) {
        List<Participation> lstPart = (List<Participation>) partRepo.findAll();
        List<Participation> lst = new ArrayList<>();
        for (Participation p: lstPart){
            if (p.getEvent().getId().equals(id)){
                lst.add( partRepo.findById(p.getPartId()).get());
            }
        }
        return lst;
    }

    @RequestMapping(value="/participations/user/{userId}", method = RequestMethod.GET)
    public @ResponseBody
    List<Participation> findByUser(@PathVariable("userId") Long id) {
        List<Participation> lstPart = (List<Participation>) partRepo.findAll();
        List<Participation> lst = new ArrayList<>();
        for (Participation p: lstPart){
            if (p.getUser().getId().equals(id)){
                lst.add(p);
            }
        }
        return lst;
    }
}
