package com.mg.eventmanager.web;

import com.mg.eventmanager.domain.Participation;
import com.mg.eventmanager.repositories.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
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
                lst.add(p);
            }
        }
        return lst;
    }

    @RequestMapping(value="/participations/member/{memberid}", method = RequestMethod.GET)
    public @ResponseBody
    List<Participation> findByMember(@PathVariable("memberid") Long id) {
        List<Participation> lstPart = (List<Participation>) partRepo.findAll();
        List<Participation> lst = new ArrayList<>();
        for (Participation p: lstPart){
            if (p.getMember().getId().equals(id)){
                lst.add(p);
            }
        }
        return lst;
    }
}
