package com.mg.eventmanager.business;

import com.mg.eventmanager.domain.*;
import com.mg.eventmanager.repositories.EventRepository;
import com.mg.eventmanager.repositories.LocationRepository;
import com.mg.eventmanager.repositories.ParticipationRepository;
import com.mg.eventmanager.repositories.MemberRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EventManagerTools {


    public static void initializeEnvironmment(EventRepository eventRepo, ParticipationRepository partRepo, MemberRepository memberRepo, LocationRepository locRepo){

        //TODO delete the next lines for final deployment
        eventRepo.deleteAll();
        partRepo.deleteAll();
        memberRepo.deleteAll();
        locRepo.deleteAll();

        /**Creating Admin**/
        Admin admin = new Admin( "admin", "mail",  true, "password");
        Admin admin2 = new Admin( "admin3", "mail3",  false, "password");
        memberRepo.save(admin);
        memberRepo.save(admin2);

        /**Creating Mmebers**/
        Member member = new Member("member", "userMail", false, "12345678");
        Member member2 = new Member("member2", "usermail2", false, "pass");
        Member member3 = new Member("member3", "usermail3", true, "pass");
        Member member4 = new Member("member4", "usermail4", true, "pass");
        Member member5 = new Member("member5", "usermail5", true, "pass");
        Member member6 = new Member("member6", "usermail6", false, "pass");
        Member member7 = new Member("member7", "usermail7", false, "pass");
        Member member8 = new Member("member8", "usermail8", true, "pass");
        Member member9 = new Member("member9", "usermail9", false, "pass");
        memberRepo.save(member);
        memberRepo.save(member2);
        memberRepo.save(member3);
        memberRepo.save(member4);
        memberRepo.save(member5);
        memberRepo.save(member6);
        memberRepo.save(member7);
        memberRepo.save(member8);
        memberRepo.save(member9);


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
        participants.add(new Participation(member, evt1));
        participants.add(new Participation(member2, evt1));
        participants.add(new Participation(member3, evt1));
        participants.add(new Participation(member4, evt1));
        participants.add(new Participation(member5, evt1));


        evt1.setMemberList(participants);
        eventRepo.save(evt1);

        for (Participation p : evt1.getMemberList()){
            Member u = p.getMember();
            List<Participation> participations = new ArrayList<>();
            participations.add(p);
            u.setParticipations(participations);
            memberRepo.save(u);
        }

        participants.clear();

        participants.add(new Participation(member6, evt2));
        participants.add(new Participation(member7, evt2));
        participants.add(new Participation(member8, evt2));
        participants.add(new Participation(member9, evt2));
        participants.add(new Participation(admin, evt2));

        evt2.setMemberList(participants);
        eventRepo.save(evt2);

        for (Participation p : evt2.getMemberList()){
            Member u = p.getMember();
            List<Participation> participations = new ArrayList<>();
            participations.add(p);
            u.setParticipations(participations);
            memberRepo.save(u);
        }


    }

}
