package com.enigma.tarkam.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "m_skill")
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id", nullable = false)
    private Integer skillId;
    @Column(name = "speed", nullable = false)
    private Integer speed;
    @Column(name = "shoot")
    private Integer shoot;
    @Column(name = "physique")
    private Integer physique;
    @Column(name = "reflexes")
    private Integer reflexes;
    @Column(name = "dribble")
    private Integer dribble;
    @Column(name = "stamina")
    private Integer stamina;
    @Column(name = "determination")
    private Integer determination;

    public Integer getSkillId() {
        return skillId;
    }

    public void setSkillId(Integer skillId) {
        this.skillId = skillId;
    }

    public Integer getSpeed() {
        return speed;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public Integer getShoot() {
        return shoot;
    }

    public void setShoot(Integer shoot) {
        this.shoot = shoot;
    }

    public Integer getPhysique() {
        return physique;
    }

    public void setPhysique(Integer physique) {
        this.physique = physique;
    }

    public Integer getReflexes() {
        return reflexes;
    }

    public void setReflexes(Integer reflexes) {
        this.reflexes = reflexes;
    }

    public Integer getDribble() {
        return dribble;
    }

    public void setDribble(Integer dribble) {
        this.dribble = dribble;
    }

    public Integer getStamina() {
        return stamina;
    }

    public void setStamina(Integer stamina) {
        this.stamina = stamina;
    }

    public Integer getDetermination() {
        return determination;
    }

    public void setDetermination(Integer determination) {
        this.determination = determination;
    }
}
