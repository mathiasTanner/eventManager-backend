package com.mg.eventmanager.domain.Business;

import com.google.appengine.repackaged.org.joda.time.format.DateTimeFormat;
import com.mg.eventmanager.domain.*;
import com.mg.eventmanager.domain.repositories.EventRepository;
import com.mg.eventmanager.domain.repositories.LocationRepository;
import com.mg.eventmanager.domain.repositories.ParticipationRepository;
import com.mg.eventmanager.domain.repositories.UserRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventManagerTools {


    public static void initializeEnvironmment(EventRepository eventRepo, ParticipationRepository partRepo, UserRepository userRepo, LocationRepository locRepo){

        //TODO delete the next lines for final deployment
        eventRepo.deleteAll();
        partRepo.deleteAll();
        userRepo.deleteAll();
        locRepo.deleteAll();

        /**Creating Admin**/
        Admin admin = new Admin( "admin", "mail",  true, "password");
        Admin admin2 = new Admin( "admin3", "mail3",  false, "password");
        userRepo.save(admin);

        /**Creating Users**/
        User user = new User("user", "userMail", false, "12345678");
        User user2 = new User("user2", "usermail2", false, "pass");
        User user3 = new User("user3", "usermail3", true, "pass");
        User user4 = new User("user4", "usermail4", true, "pass");
        User user5 = new User("user5", "usermail5", true, "pass");
        User user6 = new User("user6", "usermail6", false, "pass");
        User user7 = new User("user7", "usermail7", false, "pass");
        User user8 = new User("user8", "usermail8", true, "pass");
        User user9 = new User("user9", "usermail9", false, "pass");
        userRepo.save(user);
        userRepo.save(user2);
        userRepo.save(user3);
        userRepo.save(user4);
        userRepo.save(user5);
        userRepo.save(user6);
        userRepo.save(user7);
        userRepo.save(user8);
        userRepo.save(user9);


        /**Creating Locations**/

        Location loc1 = new Location("Pasila",60.202589, 24.934024);

        Location loc2 = new Location("Ivalo",68.657964, 27.539790);

        locRepo.save(loc1);
        locRepo.save(loc2);


        /**Creating Events**/
        //String name, LocalDate eventDate, LocalDate creationDate, Location location, String materialList, int maxNumberParticipants,int nbrOfCars, Admin creator
        Event evt1 = new Event("Event1", LocalDate.of(2020,10,10), LocalDate.now(), loc1, "matos", 5, 2, admin);
        Event evt2 = new Event("Event2", LocalDate.of(2020,9,17), LocalDate.now(), loc2, "matos2", 6, 3, admin2);

        eventRepo.save(evt1);
        eventRepo.save(evt2);

        /**Creating participations**/
        List<Participation> participants = new ArrayList<>();
        participants.add(new Participation(user, evt1));
        participants.add(new Participation(user2, evt1));
        participants.add(new Participation(user3, evt1));
        participants.add(new Participation(user4, evt1));
        participants.add(new Participation(user5, evt1));


        evt1.setMemberList(participants);
        eventRepo.save(evt1);

        for (Participation p : evt1.getMemberList()){
            User u = p.getUser();
            List<Participation> participations = new ArrayList<>();
            participations.add(p);
            u.setParticipations(participations);
            userRepo.save(u);
        }

        participants.clear();

        participants.add(new Participation(user6, evt2));
        participants.add(new Participation(user7, evt2));
        participants.add(new Participation(user8, evt2));
        participants.add(new Participation(user9, evt2));
        participants.add(new Participation(admin, evt2));

        evt2.setMemberList(participants);
        eventRepo.save(evt2);

        for (Participation p : evt2.getMemberList()){
            User u = p.getUser();
            List<Participation> participations = new ArrayList<>();
            participations.add(p);
            u.setParticipations(participations);
            userRepo.save(u);
        }

    }

}
