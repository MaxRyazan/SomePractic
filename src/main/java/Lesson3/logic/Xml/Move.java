package Lesson3.logic.Xml;

import com.google.gson.annotations.Expose;

public  final class Move {
    @Expose
    int playerId;
    @Expose
    int coordinate;
    @Expose
    public    int num;

    public Move( int playerId,  int coordinate,  int num) {
        this.playerId = playerId;
        this.coordinate = coordinate;
        this.num = num;
    }

    public Move() {
    }

    public int getPlayerId() {
        return playerId;
    }

    public int getCoordinate() {
        return coordinate;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Move{" +
                "playerId=" + playerId +
                ", coordinate=" + coordinate +
                ", num=" + num +
                '}';
    }
}