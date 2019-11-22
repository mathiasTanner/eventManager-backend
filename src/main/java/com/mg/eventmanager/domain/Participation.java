package com.mg.eventmanager.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class Participation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "partid", nullable = false, updatable = false)
    private Long partid;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "memberid")
    private Member member;
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "eventid")
    private Event event;

    public Participation(){}

    public Participation(Member member, Event event) {
        this.member = member;
        this.event = event;
    }

    public Long getPartId() {
        return partid;
    }

    public void setPartId(Long partId) {
        this.partid = partId;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
