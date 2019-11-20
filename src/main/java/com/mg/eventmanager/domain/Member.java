package com.mg.eventmanager.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="evt_member")
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "memberid", nullable = false, updatable = false)
    private Long memberid;

    @Column(name = "username", nullable = false, unique = true)
    private String username;
    private String mail;
    private boolean hasCar;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "member")
    private List<Participation> participations;
    @Column(name = "passwordHash", nullable = false)
    private String passwordHash;
    private String token;

    public Member(){}

    public Member(String username, String mail, boolean hasCar, String passwordHash) {
        this.username = username;
        this.mail = mail;
        this.hasCar = hasCar;
        this.passwordHash = passwordHash;
    }

    public Long getId() {
        return memberid;
    }

    public void setId(Long id) {
        this.memberid = id;
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(memberid, member.memberid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberid);
    }

    @Override
    public String toString() {
        return "Member{" +
                "username='" + username + '\'' +
                ", mail='" + mail + '\'' +
                '}';
    }
}
