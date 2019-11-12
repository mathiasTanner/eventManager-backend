package com.mg.eventmanager.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="evt_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userid", nullable = false, updatable = false)
    private Long userid;

    @Column(name = "username", nullable = false, unique = true)
    private String username;
    private String mail;
    private boolean hasCar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Participation> participations;
    @Column(name = "passwordHash", nullable = false)
    private String passwordHash;

    public User(){}

    public User(String username, String mail, boolean hasCar, String passwordHash) {
        this.username = username;
        this.mail = mail;
        this.hasCar = hasCar;
        this.passwordHash = passwordHash;
    }

    public Long getId() {
        return userid;
    }

    public void setId(Long id) {
        this.userid = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public boolean isHasCar() {
        return hasCar;
    }

    public void setHasCar(boolean hasCar) {
        this.hasCar = hasCar;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public List<Participation> getParticipations() {
        return participations;
    }

    public void setParticipations(List<Participation> participations) {
        this.participations = participations;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(userid, user.userid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userid);
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
