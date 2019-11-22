package com.mg.eventmanager.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Admin extends Member {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "creator")
    private List<Event> lstEvt;

    public Admin(){}

    public Admin(String username, String mail, boolean hasCar,  String passwordHash) {
        super(username, mail, hasCar, passwordHash);
    }

    public List<Event> getLstEvt() {
        return lstEvt;
    }

    public void setLstEvt(List<Event> lstEvt) {
        this.lstEvt = lstEvt;
    }
}
