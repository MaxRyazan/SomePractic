package Lesson3.logic.XmlReader;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.gson.annotations.Expose;


public class Player {
    @Expose
    private String id;
    @Expose
    private String name;
    @Expose
    private String symbol;

    private int moveCounter;

    private boolean isWinner;

    public Player( String id,  String name,  String symbol) {
        this.id = id;
        this.name = name;
        this.symbol = symbol;
        this.moveCounter = 0;
    }

    public Player() {
        this.moveCounter = 0;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSymbol() {
        return symbol;
    }
    public int getMoveCounter() {
        return moveCounter;
    }
    public boolean isWinner() {
        return isWinner;
    }
    public void setWinner(boolean winner) {
        isWinner = winner;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public void increaseMoveCount() {
        moveCounter++;
    }

    @Override
    public String toString() {
        return "Player{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", symbol=" + symbol +
                '}';
    }
}