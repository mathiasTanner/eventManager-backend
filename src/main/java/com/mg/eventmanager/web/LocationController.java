package com.mg.eventmanager.web;

import com.mg.eventmanager.domain.Location;
import com.mg.eventmanager.repositories.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class LocationController {

    @Autowired
    LocationRepository locRepo;

    @RequestMapping(value="/location/{name}", method = RequestMethod.GET)
    public @ResponseBody
    Location findEvent(@PathVariable("name") String name) {
        return locRepo.findByName(name);
    }
}
