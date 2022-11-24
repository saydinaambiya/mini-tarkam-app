package com.enigma.tarkam.model;

import jakarta.persistence.criteria.CriteriaBuilder;

public class StandingTable {
    private Integer win = 0;
    private Integer draw= 0;
    private Integer lose = 0;
    private Integer point = 0;
    private Integer goalFor = 0;
    private Integer goalAgaint = 0;
    private Integer goalDiff = 0;

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public Integer getDraw() {
        return draw;
    }

    public void setDraw(Integer draw) {
        this.draw = draw;
    }

    public Integer getLose() {
        return lose;
    }

    public void setLose(Integer lose) {
        this.lose = lose;
    }

    public Integer getPoint() {
        return point;
    }

    public void setPoint(Integer point) {
        this.point = point;
    }

    public Integer getGoalFor() {
        return goalFor;
    }

    public void setGoalFor(Integer goalFor) {
        this.goalFor = goalFor;
    }

    public Integer getGoalAgaint() {
        return goalAgaint;
    }

    public void setGoalAgaint(Integer goalAgaint) {
        this.goalAgaint = goalAgaint;
    }

    public Integer getGoalDiff() {
        return goalDiff;
    }

    public void setGoalDiff(Integer goalDiff) {
        this.goalDiff = goalDiff;
    }

    @Override
    public String toString() {
        return
                "win=" + win +
                ", draw=" + draw +
                ", lose=" + lose +
                ", point=" + point +
                ", goalFor=" + goalFor +
                ", goalAgaint=" + goalAgaint +
                ", goalDiff=" + goalDiff;
    }
}
