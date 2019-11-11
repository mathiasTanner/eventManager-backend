package com.mg.eventmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mg.eventmanager.Business.Exceptions.MaxParticipantReachedException;
import com.mg.eventmanager.Business.Exceptions.UserAlreadyRegisteredException;
import com.mg.eventmanager.Business.Exceptions.UserNotFoundException;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long eventId;
    private String name;
    private LocalDate eventDate;
    private LocalDate creationDate;
    private ArrayList<Double> location;
    private ArrayList<String> materialList;
    private int maxNumberParticipants;
    private int nbrOfCars;
    private ArrayList<User> memberList;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userId")
    private User creator;


    public Event(String name, LocalDate eventDate, LocalDate creationDate, ArrayList<Double> location, ArrayList<String> materialList, int maxNumberParticipants,int nbrOfCars, ArrayList<User> memberList, User creator) {
        this.name = name;
        this.eventDate = eventDate;
        this.creationDate = creationDate;
        this.location = location;
        this.materialList = materialList;
        this.maxNumberParticipants = maxNumberParticipants;
        this.nbrOfCars = nbrOfCars;
        this.memberList = memberList;
        this.creator = creator;
    }

    public Long getId() {
        return eventId;
    }

    public void setId(Long id) {
        this.eventId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public ArrayList<Double> getLocation() {
        return location;
    }

    public void setLocation(ArrayList<Double> location) {
        this.location = location;
    }

    public ArrayList<String> getMaterialList() {
        return materialList;
    }

    public void setMaterialList(ArrayList<String> materialList) {
        this.materialList = materialList;
    }

    public int getMaxNumberParticipants() {
        return maxNumberParticipants;
    }

    public void setMaxNumberParticipants(int maxNumberParticipants) {
        this.maxNumberParticipants = maxNumberParticipants;
    }

    public int getNbrOfCars() {
        return nbrOfCars;
    }

    public void setNbrOfCars(int nbrOfCars) {
        this.nbrOfCars = nbrOfCars;
    }

    public ArrayList<User> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<User> memberList) {
        this.memberList = memberList;
    }

    public User getUser(Long id){
        try {
            if (memberList.isEmpty()){
                throw new UserNotFoundException();
            } else {
                User user = null;
                for (User u: memberList){
                    if (u.getId()==id){
                        user = u;
                    }
                }
                if (user != null){
                    return user;
                } else{
                    throw new UserNotFoundException();
                }
            }
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void addMember(User u){
        try {
            if (memberList.size()<maxNumberParticipants){
                if (memberList.contains(u)){
                    throw new UserAlreadyRegisteredException();
                } else {
                    memberList.add(u);
                }
            } else {
                throw new MaxParticipantReachedException();
            }
        } catch (UserAlreadyRegisteredException | MaxParticipantReachedException e) {
            System.out.println(e.getMessage());
        }
    }

    public void deleteMember(User u){
        try {
            if (memberList.contains(u)){
                memberList.remove(u);
            } else {
                throw new UserNotFoundException();
            }
        } catch (UserNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    @Override
    public String toString() {
        return "Event{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Event event = (Event) o;
        return Objects.equals(eventId, event.eventId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eventId);
    }
}
