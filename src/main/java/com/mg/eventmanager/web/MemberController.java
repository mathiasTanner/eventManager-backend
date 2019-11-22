package com.mg.eventmanager.web;

import com.mg.eventmanager.domain.Member;
import com.mg.eventmanager.repositories.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class MemberController {

    @Autowired
    MemberRepository userRepo;

    @RequestMapping(value="/user/mail/{mail}", method = RequestMethod.GET)
    public @ResponseBody
    Member findAdminByMail(@PathVariable("mail") String mail) {
        return userRepo.findByMail(mail);
    }

    @RequestMapping(value="/user/username/{username}", method = RequestMethod.GET)
    public @ResponseBody
    Member findAdminByUsername(@PathVariable("username") String username) {
        return userRepo.findByUsername(username);
    }


}
