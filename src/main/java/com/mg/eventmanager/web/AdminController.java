package com.mg.eventmanager.web;

import com.mg.eventmanager.domain.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class AdminController {
    @Autowired
    AdminRepository adminRepo;
}
