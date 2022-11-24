package com.enigma.tarkam.repository;

import com.enigma.tarkam.entity.GameResult;
import com.enigma.tarkam.model.StandingTable;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.*;
import java.util.stream.Collectors;

public class GameResultRepositoryImpl implements GameResultRepository {
    private final EntityManager entityManager;

    public GameResultRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public void create(GameResult gameResult) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(gameResult);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
            throw new RuntimeException(e);
        }
    }

    @Override
    public GameResult findOne(Integer id) {
        GameResult gameResult = entityManager.find(GameResult.class, id);
        if (gameResult != null) {
            return gameResult;
        }
        throw new RuntimeException("Data not found");
    }

    @Override
    public List<GameResult> findAll(int page, int pageSize) {
        TypedQuery<GameResult> typedQuery = entityManager.createQuery("SELECT gr FROM GameResult gr ORDER BY gr.gameResultId", GameResult.class);
        typedQuery.setFirstResult((page - 1) * pageSize);
        typedQuery.setMaxResults(pageSize);
        return typedQuery.getResultList();
    }

    @Override
    public List<GameResult> findAll() {
        TypedQuery<GameResult> typedQuery = entityManager.createQuery("SELECT gr FROM GameResult gr ORDER BY gr.gameResultId", GameResult.class);
        return typedQuery.getResultList();
    }

    @Override
    public Map<String, StandingTable> getStanding() {
        List<GameResult> allGame = findAll();
        Map<String, StandingTable> standingTableMap = new LinkedHashMap<>();

        for (GameResult gameResult : allGame) {
            StandingTable homeStanding;
            StandingTable awayStanding;

            homeStanding = standingTableMap.get(gameResult.getHomeTeam().getTeamName());
            awayStanding = standingTableMap.get(gameResult.getAwayTeam().getTeamName());

            if (homeStanding == null) {
                homeStanding = new StandingTable();
                standingTableMap.put(gameResult.getHomeTeam().getTeamName(), homeStanding);
            }
            if (awayStanding == null) {
                awayStanding = new StandingTable();
                standingTableMap.put(gameResult.getAwayTeam().getTeamName(), awayStanding);
            }

            boolean homeWin = gameResult.getHomeScore() > gameResult.getAwayScore();
            boolean draw = gameResult.getHomeScore().equals(gameResult.getAwayScore());

            if (draw) {
                homeStanding.setDraw(homeStanding.getDraw() + 1);
                awayStanding.setDraw(awayStanding.getDraw() + 1);
            } else if (homeWin) {
                homeStanding.setWin(homeStanding.getWin() + 1);
                awayStanding.setLose(awayStanding.getLose() + 1);
            } else {
                awayStanding.setWin(awayStanding.getWin() + 1);
                homeStanding.setLose(homeStanding.getLose() + 1);
            }

            //result of win n draw
            homeStanding.setPoint(homeStanding.getWin() * 3 + homeStanding.getDraw());
            awayStanding.setPoint(awayStanding.getWin() * 3 + awayStanding.getDraw());


            //result of goal for team
            homeStanding.setGoalFor(homeStanding.getGoalFor() + gameResult.getHomeScore());
            awayStanding.setGoalFor(awayStanding.getGoalFor() + gameResult.getAwayScore());

            //result of goal againt
            homeStanding.setGoalAgaint(homeStanding.getGoalAgaint() + gameResult.getAwayScore());
            awayStanding.setGoalAgaint(awayStanding.getGoalAgaint() + gameResult.getHomeScore());

            //result of goal diff
            homeStanding.setGoalDiff(homeStanding.getGoalFor() - homeStanding.getGoalAgaint());
            awayStanding.setGoalDiff(awayStanding.getGoalFor() - awayStanding.getGoalAgaint());

        }

        Comparator<Map.Entry<String, StandingTable>> sortPoint = (Comparator.comparingInt(st -> st.getValue().getPoint()));
//        Comparator<Map.Entry<String, StandingTable>> sortGoalDiff = (Comparator.comparingInt(st -> st.getValue().getGoalDiff()));

//        Map<String, StandingTable> pointSorted =standingTableMap.entrySet().stream().sorted(sortPoint.reversed()).sorted(sortGoalDiff.reversed())
//                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));

        return standingTableMap.entrySet().stream().sorted(sortPoint.reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
    }
}
