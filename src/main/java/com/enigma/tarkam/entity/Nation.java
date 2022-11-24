package com.enigma.tarkam.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "m_nation")
public class Nation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nation_id", nullable = false)
    private Integer nationId;
    @Column(name = "nation_name", nullable = false)
    private String nationName;

    public Integer getNationId() {
        return nationId;
    }

    public void setNationId(Integer nationId) {
        this.nationId = nationId;
    }

    public String getNationName() {
        return nationName;
    }

    public void setNationName(String nationName) {
        this.nationName = nationName;
    }
}
