package com.enigma.tarkam.repository;

import com.enigma.tarkam.entity.GameResult;
import com.enigma.tarkam.model.StandingTable;

import java.util.List;
import java.util.Map;

public interface GameResultRepository {
    void create(GameResult gameResult);
    GameResult findOne(Integer id);
    List<GameResult> findAll(int page, int pageSize);
    List<GameResult> findAll();
    Map<String, StandingTable> getStanding();
}
