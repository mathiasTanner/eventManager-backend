package com.mg.eventmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mg.eventmanager.domain.Event;
import com.mg.eventmanager.domain.User;

import javax.persistence.*;

@Entity
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "partId", nullable = false, updatable = false)
    private Long partId;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "eventId")
    private Event event;

    public Participation(){}

    public Participation(User user, Event event) {
        this.user = user;
        this.event = event;
    }

    public Long getPartId() {
        return partId;
    }

    public void setPartId(Long partId) {
        this.partId = partId;
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
