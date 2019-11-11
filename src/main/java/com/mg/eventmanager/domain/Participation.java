package com.mg.eventmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mg.eventmanager.domain.Event;
import com.mg.eventmanager.domain.User;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class Participation {
    private Long id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userId")
    private User user;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "userId")
    private Event event;
}
