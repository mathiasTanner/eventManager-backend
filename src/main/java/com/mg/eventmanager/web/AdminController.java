package com.mg.eventmanager.web;

import com.mg.eventmanager.domain.Admin;
import com.mg.eventmanager.domain.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class AdminController {
    @Autowired
    AdminRepository adminRepo;

    @RequestMapping(value="/admin/mail/{mail}", method = RequestMethod.GET)
    public @ResponseBody
    Admin findAdminByMail(@PathVariable("mail") String mail) {
        return adminRepo.findByMail(mail);
    }

    @RequestMapping(value="/admin/username/{username}", method = RequestMethod.GET)
    public @ResponseBody
    Admin findAdminByUsername(@PathVariable("username") String username) {
        return adminRepo.findByUsername(username);
    }
}
