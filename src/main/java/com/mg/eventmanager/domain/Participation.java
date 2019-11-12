package com.mg.eventmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mg.eventmanager.domain.Event;
import com.mg.eventmanager.domain.User;

import javax.persistence.*;

@Entity
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "partid", nullable = false, updatable = false)
    private Long partid;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userid")
    private User user;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "eventid")
    private Event event;

    public Participation(){}

    public Participation(User user, Event event) {
        this.user = user;
        this.event = event;
    }

    public Long getPartId() {
        return partid;
    }

    public void setPartId(Long partId) {
        this.partid = partId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
