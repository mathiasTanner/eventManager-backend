package com.mg.eventmanager.web;

import com.mg.eventmanager.Business.Role;
import com.mg.eventmanager.domain.User;
import com.mg.eventmanager.domain.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Optional;

@Controller
public class UserController {
    @Autowired
    private UserRepository repo;

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public @ResponseBody List<User> findAllUsers() {
        return (List<User>)repo.findAll();
    }

    @RequestMapping(value="/user/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<User> findUser(@PathVariable("id") Long id) {
        return repo.findById(id);
    }

    @RequestMapping(value="/user/admin", method = RequestMethod.GET)
    public @ResponseBody List<User> findAllAdmin() {
        return (List<User>)repo.findByRole(Role.ADMIN);
    }

    @RequestMapping(value="/user/member", method = RequestMethod.GET)
    public @ResponseBody List<User> findAllMember() {
        return (List<User>)repo.findByRole(Role.MEMBER);
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
