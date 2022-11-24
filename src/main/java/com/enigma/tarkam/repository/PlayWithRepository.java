package com.enigma.tarkam.repository;

import com.enigma.tarkam.entity.PlayWith;

import java.util.List;

public interface PlayWithRepository {
    void crete(PlayWith playWith);
    PlayWith findOne(Integer id);
    List<PlayWith> findAll(int page, int pageSize);
}
