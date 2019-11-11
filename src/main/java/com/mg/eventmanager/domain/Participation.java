package com.mg.eventmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mg.eventmanager.domain.Event;
import com.mg.eventmanager.domain.User;

import javax.persistence.*;

@Entity
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "part_id", nullable = false, updatable = false)
    private Long id;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "id")
    private User user;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "eventId")
    private Event event;
}
