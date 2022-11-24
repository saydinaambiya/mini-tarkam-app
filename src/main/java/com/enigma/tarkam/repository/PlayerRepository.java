package com.enigma.tarkam.repository;

import com.enigma.tarkam.entity.Player;

import java.util.List;

public interface PlayerRepository {
    void create(Player player);
    Player findOne(Integer id);
    List<Player> findAll(int page, int pageSize);
    void update(Player player);
}
