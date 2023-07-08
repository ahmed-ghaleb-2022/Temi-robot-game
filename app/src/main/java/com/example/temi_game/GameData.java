package com.example.temi_game;

public class GameData {
    private static final GameData ourInstance = new GameData();

    public static GameData getInstance() {
        return ourInstance;
    }

    private GameData() {
    }

    private int playerCount;
    private int goalSeconds;

    public int getPlayerCount() {
        return playerCount;
    }

    public void setPlayerCount(int playerCount) {
        this.playerCount = playerCount;
    }

    public int getGoalSeconds() {
        return goalSeconds;
    }

    public void setGoalSeconds(int goalSeconds) {
        this.goalSeconds = goalSeconds;
    }
}
