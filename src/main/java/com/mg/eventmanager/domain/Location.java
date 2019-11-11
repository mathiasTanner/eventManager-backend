package com.mg.eventmanager.domain;

import javax.persistence.Entity;

@Entity
public class Location {
    private Long locId;
    private Double latitude;
    private Double longitude;

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
}
