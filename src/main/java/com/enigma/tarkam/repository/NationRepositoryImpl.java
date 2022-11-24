package com.enigma.tarkam.repository;

import com.enigma.tarkam.entity.Nation;
import jakarta.persistence.EntityManager;

public class NationRepositoryImpl implements NationRepository{
    private final EntityManager entityManager;

    public NationRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Nation nation) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(nation);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Nation findOne(Integer id) {
        Nation nation = entityManager.find(Nation.class, id);
        if (nation != null) {
            return nation;
        }
        throw new RuntimeException("Nation not found");
    }
}
