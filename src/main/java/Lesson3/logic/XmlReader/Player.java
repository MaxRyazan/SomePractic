package Lesson3.logic.XmlReader;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Player {
    private String id;
    private String name;
    private String symbol;
    @JsonIgnore
    private int moveCounter;
    @JsonIgnore
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
@JsonIgnore
    public int getMoveCounter() {
        return moveCounter;
    }
@JsonIgnore
    public boolean isWinner() {
        return isWinner;
    }
@JsonIgnore
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
@JsonIgnore
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