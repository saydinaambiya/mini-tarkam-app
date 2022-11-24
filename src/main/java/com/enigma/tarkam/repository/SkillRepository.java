package com.enigma.tarkam.repository;

import com.enigma.tarkam.entity.Skill;

public interface SkillRepository {
    void create(Skill skill);
    Skill findOne(Integer id);
}
