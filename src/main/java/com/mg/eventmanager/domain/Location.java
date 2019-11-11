package com.mg.eventmanager.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loc_id", nullable = false, updatable = false)
    private Long locId;
    private Double latitude;
    private Double longitude;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "location")
    private List<Event> evtLst;

    public Location(){}

    public Location(Long locId, Double latitude, Double longitude) {
        this.locId = locId;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Long getLocId() {
        return locId;
    }

    public void setLocId(Long locId) {
        this.locId = locId;
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
