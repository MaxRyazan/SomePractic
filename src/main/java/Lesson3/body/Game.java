package Lesson3.body;

import Lesson3.LauncherNew;
import Lesson3.Parse;
import Lesson3.logic.*;
import Lesson3.logic.Json.ParsingJson;
import Lesson3.logic.Xml.Move;
import Lesson3.logic.Xml.ParsingXml;
import Lesson3.logic.Xml.Player;

import com.google.gson.annotations.Expose;

import java.util.ArrayList;
import java.util.List;

public class Game {
    @Expose
    public static Player playerOne;
    @Expose
    public static Player playerTwo;
    @Expose
    public static  List<Move> moves = new ArrayList<>();

//    public static  List<Player> players = new ArrayList<>();

    private final Logs logs;

    private final static Maps maps = new Maps();

    private final Users users;

    private final WinCheck winCheck;

    private final DrawCheck drawCheck;

    private final ParsingXml parsingXml;

    private final boolean isFromFile;

    private final Parse parser;


    public Game(boolean isFromFile, LauncherNew.ConvertType convertType)  {
        this.users = new Users();
        this.winCheck = new WinCheck();
        this.drawCheck = new DrawCheck();
        this.logs = new Logs();
        this.parsingXml = new ParsingXml();
        this.isFromFile = isFromFile;

        if(LauncherNew.ConvertType.XML.equals(convertType)){
            parser = new ParsingXml();
        } else {
                parser = new ParsingJson();
        }

        playerOne = new Player();
        playerTwo = new Player();

    }

    public void play()
            throws Exception {
        if (!isFromFile) {
            playerOne.setName(CheckGamersNames.getPlayersName("Введите имя первого игрока:"));
            playerOne.setId("1");
            playerOne.setSymbol("X");

            playerTwo.setName(CheckGamersNames.getPlayersName("Введите имя второго игрока:"));
            playerTwo.setId("2");
            playerTwo.setSymbol("O");
        } else {
            playerOne = GamePlay.players.get(0);
            playerTwo = GamePlay.players.get(1);
        }

        maps.printMapOnce();

        System.out.println(playerOne.getName() + " make move using symbol '" + playerOne.getSymbol() + "'");
        System.out.println(playerTwo.getName() + " make move using symbol '" + playerTwo.getSymbol() + "'");
        System.out.println("Let's ROCK!!!");

        boolean gameEnded = false;

        while (!gameEnded) {
            gameEnded = makePlayerMove(playerOne);

            if (!gameEnded) {
                gameEnded = makePlayerMove(playerTwo);
            }
        }

        if(!isFromFile) {
           parser.parse(playerOne, playerTwo, moves);
        }

}
    private boolean makePlayerMove(Player player) {
        System.out.println(player.getName() + " '" + player.getSymbol() + "' :");

        Cell movedCell = users.printUserMove(player, isFromFile);

        moves.add(new Move(
                Integer.parseInt(player.getId()),
                movedCell.getCellNumber(),
                player.getMoveCounter()
        ));

        Maps.refreshMap();

        if (winCheck.uisUerWin(player.getSymbol())) {
            player.setWinner(true);
            logs.loggingWin(player);
            System.out.println(player.getName() + " '" + player.getSymbol() + "' WIN!");
            System.out.println("GAME OVER");
            return true;
        } else if (drawCheck.check()) {
            logs.loggingIfDraw();
            System.out.println("Sorry.. nobody win.. its a DRAW!");
            System.out.println("GAME OVER");
            return true;
        }
        return false;
    }
}