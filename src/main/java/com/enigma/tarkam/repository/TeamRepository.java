package com.enigma.tarkam.repository;

import com.enigma.tarkam.entity.Team;

import java.util.List;

public interface TeamRepository {
    void crete(Team team);
    Team findOne(Integer id);
    List<Team> findAll(int page, int pageSize);
    void update(Team team);
}
