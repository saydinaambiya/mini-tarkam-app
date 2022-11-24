package com.enigma.tarkam.repository;

import com.enigma.tarkam.entity.PlayWith;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PlayWithRepositoryImpl implements PlayWithRepository{
    private final EntityManager entityManager;

    public PlayWithRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void crete(PlayWith playWith) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(playWith);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public PlayWith findOne(Integer id) {
        PlayWith playWith = entityManager.find(PlayWith.class, id);
        if (playWith != null) {
            return playWith;
        }
        throw new RuntimeException("Data not found");
    }

    @Override
    public List<PlayWith> findAll(int page, int pageSize) {
        TypedQuery<PlayWith> typedQuery = entityManager.createQuery("SELECT p FROM PlayWith p ORDER BY p.team", PlayWith.class);
        typedQuery.setFirstResult((page-1)*pageSize);
        typedQuery.setMaxResults(pageSize);
        return typedQuery.getResultList();
    }
}
