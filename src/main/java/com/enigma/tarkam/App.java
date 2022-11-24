package com.enigma.tarkam;

import com.enigma.tarkam.constants.Position;
import com.enigma.tarkam.entity.*;
import com.enigma.tarkam.model.StandingTable;
import com.enigma.tarkam.repository.*;
import com.enigma.tarkam.util.DateUtil;
import com.enigma.tarkam.util.JpaUtil;
import jakarta.persistence.EntityManager;

import java.sql.Date;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;


public class App {
    static EntityManager entityManager = JpaUtil.getEntityManger();

    public static void main(String[] args) {
//        insertGameResult();
        showStanding();
    }



    static void showStanding() {
        GameResultRepository grp = new GameResultRepositoryImpl(entityManager);
        Map<String, StandingTable> stan = grp.getStanding();
        for (Map.Entry<String, StandingTable> standingTableEntry : stan.entrySet() ) {
            System.out.println("["+standingTableEntry.getKey()+" "+standingTableEntry.getValue()+"]");
            System.out.println();

        }
    }


    static void insertGameResult() {
        GameResultRepository grp = new GameResultRepositoryImpl(entityManager);
        TeamRepository trp = new TeamRepositoryImpl(entityManager);
        PlayWithRepository pwr = new PlayWithRepositoryImpl(entityManager);
        GameResult gameResult = new GameResult();

        gameResult.setHomeTeam(trp.findOne(3));
        gameResult.setAwayTeam(trp.findOne(4));
        gameResult.setHomeScore(1);
        gameResult.setAwayScore(1);
        grp.create(gameResult);
    }

    static void findAllPlayerAndSquad() {
        PlayWithRepository playerRepository = new PlayWithRepositoryImpl(entityManager);
        System.out.println(playerRepository.findAll(1, 2));

    }


    //    /*
    static void testingPlayWithRepo() {
        PlayWithRepository play = new PlayWithRepositoryImpl(entityManager);
        PlayerRepository playerRepository = new PlayerRepositoryImpl(entityManager);
        TeamRepository teamRepository = new TeamRepositoryImpl(entityManager);
        PlayWith playWith = new PlayWith();

        playWith.setPlayer(playerRepository.findOne(2));
        playWith.setTeam(teamRepository.findOne(1));

        play.crete(playWith);
    }
//     */

    /*
    static void testingCreateNation(){
        NationRepository nationRepository = new NationRepositoryImpl(entityManager);
        Nation nation = new Nation();
        nation.setNationName("Malaysia");
        nationRepository.create(nation);

    }

 */

    //    /*
    static void testingRegisterPlayer() {
//        TeamRepository teamRepository = new TeamRepositoryImpl(entityManager);
//        Team team = new Team();
//        team.setTeamName("Team D");
//        team.setCity("Jakpus");
//        team.setFoundDate(Date.valueOf("2022-10-13"));
//        teamRepository.crete(team);


        Skill skill = new Skill();
        skill.setSpeed(7);
        skill.setPhysique(6);
        skill.setShoot(7);
        skill.setDribble(8);
        skill.setStamina(7);
        skill.setDetermination(7);
        skill.setReflexes(7);


        PlayerRepository playerRepository = new PlayerRepositoryImpl(entityManager);
        Nation nation = entityManager.find(Nation.class, 1);
        Player player = new Player();
        player.setFullName("Toni Kroos");
        player.setBirthDate(Date.valueOf("1989-04-16").toLocalDate());
        player.setHeight(174);
        player.setPosition(Position.MD);
        player.setNationId(nation);
        player.setSkill(skill);
        playerRepository.create(player);
    }
//*/


}
