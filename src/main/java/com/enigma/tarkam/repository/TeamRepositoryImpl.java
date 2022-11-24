package com.enigma.tarkam.repository;

import com.enigma.tarkam.entity.Team;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class TeamRepositoryImpl implements TeamRepository{
    private final EntityManager entityManager;

    public TeamRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void crete(Team team) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(team);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Team findOne(Integer id) {
        Team team = entityManager.find(Team.class, id);
        if (team != null) {
            return team;
        }
        throw new RuntimeException("Team not found");
    }

    @Override
    public List<Team> findAll(int page, int pageSize) {
        TypedQuery<Team> typedQuery = entityManager.createQuery("SELECT t FROM Team t ORDER BY t.teamId", Team.class);
        typedQuery.setFirstResult((page-1)*pageSize);
        typedQuery.setMaxResults(pageSize);
        return typedQuery.getResultList();
    }

    @Override
    public void update(Team team) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(team);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }
}
