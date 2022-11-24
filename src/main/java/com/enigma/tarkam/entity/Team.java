package com.enigma.tarkam.entity;

import jakarta.persistence.*;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "m_team")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id", nullable = false)
    private Integer teamId;
    @Column(name = "team_name", nullable = false)
    private String teamName;
    @Column(name = "city", nullable = false)
    private String city;
    @Column(name = "found_date", nullable = false)
    private Date foundDate;
//    @ManyToMany(mappedBy = "playerTeam")
//    Set<Player> players;

    public Integer getTeamId() {
        return teamId;
    }

    public void setTeamId(Integer teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getFoundDate() {
        return foundDate;
    }

    public void setFoundDate(Date foundDate) {
        this.foundDate = foundDate;
    }

//    public Set<Player> getPlayers() {
//        return players;
//    }
//
//    public void setPlayers(Set<Player> players) {
//        this.players = players;
//    }
}
