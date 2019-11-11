package com.mg.eventmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;



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
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "locId")
    private Location location;
    private ArrayList<String> materialList;
    private int maxNumberParticipants;
    private int nbrOfCars;
    @OneToMany (cascade = CascadeType.ALL, mappedBy = "event")
    private ArrayList<Participation> memberList;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userId")
    private Admin creator;

    public Event(){}

    public Event(String name, LocalDate eventDate, LocalDate creationDate, Location location, ArrayList<String> materialList, int maxNumberParticipants,int nbrOfCars, Admin creator) {
        this.name = name;
        this.eventDate = eventDate;
        this.creationDate = creationDate;
        this.location = location;
        this.materialList = materialList;
        this.maxNumberParticipants = maxNumberParticipants;
        this.nbrOfCars = nbrOfCars;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
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

    public ArrayList<Participation> getMemberList() {
        return memberList;
    }

    public void setMemberList(ArrayList<Participation> memberList) {
        this.memberList = memberList;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(Admin creator) {
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
