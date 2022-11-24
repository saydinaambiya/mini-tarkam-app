package com.enigma.tarkam.repository;

import com.enigma.tarkam.entity.Nation;

public interface NationRepository {
    void create(Nation nation);
    Nation findOne(Integer id);
}
