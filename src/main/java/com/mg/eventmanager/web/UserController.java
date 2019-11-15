package com.mg.eventmanager.web;

import com.mg.eventmanager.domain.Admin;
import com.mg.eventmanager.domain.User;
import com.mg.eventmanager.domain.repositories.AdminRepository;
import com.mg.eventmanager.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@Controller
public class UserController {
    @Autowired
    private UserRepository repo;

    @Autowired
    private AdminRepository adminRepo;

    @RequestMapping(value="/users", method = RequestMethod.GET)
    public @ResponseBody List<User> findAllUsers() {
        return (List<User>)repo.findAll();
    }

    @RequestMapping(value="/user/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<User> findUser(@PathVariable("id") Long id) {
        return repo.findById(id);
    }

    @RequestMapping(value="/user/admin", method = RequestMethod.GET)
    public @ResponseBody List<Admin> findAllAdmin() {
        return ((List<Admin>)adminRepo.findAll());
    }

    @RequestMapping(value="/user/member", method = RequestMethod.GET)
        //TODO implement method after creating repo
    public @ResponseBody List<User> findAllMember() {
        return null;
    }

    @RequestMapping(value = "/user/save", method = RequestMethod.POST)
    public void saveUser(User user){
        repo.save(user);
    }

    @RequestMapping(value="user/delete/{id}", method = RequestMethod.GET)
    public void deleteUser(@PathVariable("id") Long id){
        repo.deleteById(id);
    }


}
