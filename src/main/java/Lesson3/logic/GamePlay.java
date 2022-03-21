
package Lesson3.logic;

import Lesson3.logic.Xml.Move;
import Lesson3.logic.Xml.Player;
import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class GamePlay {
    @Expose
    Player playerOne;
    @Expose
    Player playerTwo;
    @Expose
    public List<Move> moves = new ArrayList<>();
    @Expose
    private GameResult gameResult;

    public static  List<Player> players = new ArrayList<>();


    public GamePlay(Player player1,  Player player2, List<Move> moves) {
        playerOne = player1;
        playerTwo = player2;
        this.moves = moves;
    }

    public GamePlay() {
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(final Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(final Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(final List<Move> moves) {
        this.moves = moves;
    }

    @Override
    public String toString() {
        return "GamePlay{" +
                "moves=" + moves +
                '}';
    }

    public void setGameResult(final GameResult gameResult) {
        this.gameResult = gameResult;
    }
}