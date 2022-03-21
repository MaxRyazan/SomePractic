package Lesson3.logic;

import Lesson3.logic.XmlReader.Player;
import com.google.gson.annotations.Expose;

public class GameResult {
    @Expose
    private Player player;
    @Expose
    private String drawString;

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(final Player player) {
        this.player = player;
    }

    public GameResult() {

    }

    public  void initDrawString() {
        this.drawString = "its DRAW";
    }

    @Override
    public String toString() {
        return "GameResult{" +
                "player=" + player +
                ", drawString='" + drawString + '\'' +
                '}';
    }
}
