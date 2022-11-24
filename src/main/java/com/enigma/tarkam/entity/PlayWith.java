package com.enigma.tarkam.entity;

import jakarta.persistence.*;


@Entity
@Table(name = "t_squad")
public class PlayWith {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "play_with_id")
    private Integer playWithId;

    @ManyToOne
    @JoinColumn(name = "player_id", foreignKey = @ForeignKey(name = "fk_player_id"), referencedColumnName = "player_id")
    Player player;

    @ManyToOne
    @JoinColumn(name = "team_id", foreignKey = @ForeignKey(name = "fk_team_id"), referencedColumnName = "team_id")
    Team team;

    public Integer getPlayWithId() {
        return playWithId;
    }

    public void setPlayWithId(Integer playWithId) {
        this.playWithId = playWithId;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "\nPlayer Name : " + player.getFullName() +
                "\nPosition : " + player.getPosition() +
                "\nClub : " + team.getTeamName();
    }
}
