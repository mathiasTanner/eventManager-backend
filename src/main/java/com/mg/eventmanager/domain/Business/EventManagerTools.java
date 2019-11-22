package com.mg.eventmanager.domain.Business;

import com.mg.eventmanager.domain.Admin;
import com.mg.eventmanager.domain.User;
import com.mg.eventmanager.domain.repositories.EventRepository;
import com.mg.eventmanager.domain.repositories.ParticipationRepository;
import com.mg.eventmanager.domain.repositories.UserRepository;

public class EventManagerTools {


    public static void initializeEnvironmment(EventRepository eventRepo, ParticipationRepository partRepo, UserRepository userRepo){
        eventRepo.deleteAll();
        partRepo.deleteAll();
        userRepo.deleteAll();

        /**Creating Admin**/
        Admin admin = new Admin( "admin", "mail",  true, "password");
        userRepo.save(admin);

        /**Creating Users**/
        User user = new User("user", "userMail", false, "12345678");

        userRepo.save(user);


    }
}
