package Lesson3.logic.Json;

import Lesson3.body.Game;
import Lesson3.logic.GameResult;
import Lesson3.logic.Xml.Move;
import Lesson3.logic.Xml.Player;
import java.util.List;

public class JsonRoot {

    private Player playerOne;
    private Player playerTwo;

    List<Move> moves;

    GameResult gameResult;

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne(Player playerOne) {
        this.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(Player playerTwo) {
        this.playerTwo = playerTwo;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(final List<Move> moves) {
        this.moves = moves;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public void setGameResult(final GameResult gameResult) {
        this.gameResult = gameResult;
    }

    @Override
    public String toString() {
        return "JsonRoot{" +
                "player1=" + playerOne +
                ", player2=" + playerTwo +
                ", moveList=" + moves +
                ", gameResult=" + gameResult +
                '}';
    }
}
