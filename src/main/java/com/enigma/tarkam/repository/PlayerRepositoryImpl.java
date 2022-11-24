package com.enigma.tarkam.repository;

import com.enigma.tarkam.entity.Player;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class PlayerRepositoryImpl implements PlayerRepository {
    private final EntityManager entityManager;

    public PlayerRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(Player player) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(player);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public Player findOne(Integer id) {
        Player player = entityManager.find(Player.class, id);
        if (player != null) {
            return player;
        }
        throw new RuntimeException("Player not found");
    }

    @Override
    public List<Player> findAll(int page, int pageSize) {
        TypedQuery<Player> typedQuery = entityManager.createQuery("SELECT p FROM Player p ORDER BY p.playerId", Player.class);
        typedQuery.setFirstResult((page - 1) * pageSize);
        typedQuery.setMaxResults(pageSize);
        return typedQuery.getResultList();
    }

    @Override
    public void update(Player player) {
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(player);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }
}
