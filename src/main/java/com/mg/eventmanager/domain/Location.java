package com.mg.eventmanager.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "locid", nullable = false, updatable = false)
    private Long locid;
    private String name;
    private Double latitude;
    private Double longitude;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private List<Event> evtLst;

    public Location(){}

    public Location(String name, Double latitude, Double longitude) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getLocId() {
        return locid;
    }

    public void setLocId(Long locId) {
        this.locid = locId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public List<Event> getEvtLst() {
        return evtLst;
    }

    public void setEvtLst(List<Event> evtLst) {
        this.evtLst = evtLst;
    }
}
