package com.mg.eventmanager.web;

import com.mg.eventmanager.domain.Participation;
import com.mg.eventmanager.domain.repositories.ParticipationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class ParticipationController {
    @Autowired
    ParticipationRepository partRepo;

    @RequestMapping(value="/participations/{eventId}", method = RequestMethod.GET)
    public @ResponseBody
    List<Participation> findByEvent(@PathVariable("eventId") Long id) {
        return partRepo.findByEvent(id);
    }
}
