package com.enigma.tarkam.repository;

import com.enigma.tarkam.entity.Skill;
import jakarta.persistence.EntityManager;

public class SkillRepositoryImpl implements SkillRepository{
    private final EntityManager entityManager;

    public SkillRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Skill skill) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(skill);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Skill findOne(Integer id) {
        Skill skill = entityManager.find(Skill.class, id);
        if (skill != null) {
            return skill;
        }
        throw new RuntimeException("Skill not found");
    }
}
