
package Lesson3.logic;

import Lesson3.body.Game;
import Lesson3.logic.XmlReader.Move;
import Lesson3.logic.XmlReader.Player;

import java.util.ArrayList;
import java.util.List;

public class GamePlay {
    Player playerOne;
    Player playerTwo;
    public List<Move> moves = new ArrayList<>();



    public GamePlay(Player player1,  Player player2, List<Move> moves) {
        playerOne = player1;
        playerTwo = player2;
        this.moves = moves;
    }

    public GamePlay() {
    }

    public List<Move> getMoves() {
        return moves;
    }

    public void setMoves(final List<Move> moves) {
        this.moves = moves;
    }

    public Player getPlayerOne() {
        return playerOne;
    }

    public void setPlayerOne( Player playerOne) {
        Game.playerOne = playerOne;
    }

    public Player getPlayerTwo() {
        return playerTwo;
    }

    public void setPlayerTwo(final Player playerTwo) {
       Game.playerTwo = playerTwo;
    }

    @Override
    public String toString() {
        return "GamePlay{" +
                "moves=" + moves +
                '}';
    }
}