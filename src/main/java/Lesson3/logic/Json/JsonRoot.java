package Lesson3.logic.Json;


import Lesson3.logic.GameResult;
import Lesson3.logic.XmlReader.Move;
import Lesson3.logic.XmlReader.Player;
import java.util.List;
import static Lesson3.body.Game.*;

public class JsonRoot {

private Player player1 = playerOne;
private Player player2 = playerTwo;

List<Move> moveList = moves;

GameResult gameResult;

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1( Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2( Player player2) {
        this.player2 = player2;
    }

    public List<Move> getMoveList() {
        return moveList;
    }

    public void setMoveList(final List<Move> moveList) {
        this.moveList = moveList;
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
                "player1=" + player1 +
                ", player2=" + player2 +
                ", moveList=" + moveList +
                ", gameResult=" + gameResult +
                '}';
    }
}
