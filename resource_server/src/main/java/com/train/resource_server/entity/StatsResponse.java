package com.train.resource_server.entity;

public class StatsResponse {

    private String userChoice;

    private Statistic stat;

    public StatsResponse(String userChoice, Statistic stat) {
        this.userChoice = userChoice;
        this.stat = stat;
    }

    public String getUserChoice() {
        return userChoice;
    }

    public Statistic getStat() {
        return stat;
    }
}
