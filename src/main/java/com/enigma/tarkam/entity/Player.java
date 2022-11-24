package com.enigma.tarkam.entity;

import com.enigma.tarkam.constants.Position;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "m_player")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "player_id", nullable = false)
    private Integer playerId;
    @Column(name = "full_name", nullable = false, length = 50)
    private String fullName;
    @Column(name = "birth_date", nullable = false)
    private LocalDate birthDate;
    @Column(name = "height", nullable = false)
    private Integer height;
    @Column(name = "position", nullable = false)
    @Enumerated(EnumType.STRING)
    private Position position;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nation_id", nullable = false)
    private Nation nationId;

//    @ManyToMany
//    @JoinTable(
//            name = "t_squad",
//            joinColumns = @JoinColumn(name = "player_id"),
//            inverseJoinColumns = @JoinColumn(name = "team_id")
//    )
//    Set<Team> playerTeam;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "skill")
    private Skill skill;

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Nation getNationId() {
        return nationId;
    }

    public void setNationId(Nation nationId) {
        this.nationId = nationId;
    }

//    public Set<Team> getPlayerTeam() {
//        return playerTeam;
//    }
//
//    public void setPlayerTeam(Set<Team> playerTeam) {
//        this.playerTeam = playerTeam;
//    }

    public Skill getSkill() {
        return skill;
    }

    public void setSkill(Skill skill) {
        this.skill = skill;
    }
}
