package Lesson3.body;

import Lesson3.LauncherNew;
import Lesson3.logic.CheckGamersNames;
import Lesson3.logic.DrawCheck;
import Lesson3.logic.Logs;
import Lesson3.logic.ParsingXml;
import Lesson3.logic.Users;
import Lesson3.logic.WinCheck;
import Lesson3.logic.XmlReader.Move;
import Lesson3.logic.XmlReader.Player;
import Lesson3.logic.XmlReader.Root;
import com.google.gson.annotations.Expose;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.TransformerException;

import static Lesson3.LauncherNew.parsingJson;

public class Game {
    @Expose
    public static Player playerOne;
    @Expose
    public static Player playerTwo;
    @Expose
    public static  List<Move> moves = new ArrayList<>();

    private final Logs logs;

    private final static Maps maps = new Maps();

    private final Users users;

    private final WinCheck winCheck;

    private final DrawCheck drawCheck;

    private final ParsingXml parsingXml;

    private final boolean isFromFile;

    public Game(final Users users,
                final WinCheck winCheck, final DrawCheck drawCheck,
                final Logs logs, final ParsingXml parsingXml, boolean isFromFile) {
        this.users = users;
        this.winCheck = winCheck;
        this.drawCheck = drawCheck;
        this.logs = logs;
        this.parsingXml = parsingXml;
        playerOne = new Player();
        playerTwo = new Player();
        this.isFromFile = isFromFile;
    }

    public void play()
            throws FileNotFoundException, ParserConfigurationException, TransformerException {
        if (!isFromFile) {
            playerOne.setName(CheckGamersNames.getPlayersName("Введите имя первого игрока:"));
            playerOne.setId("1");
            playerOne.setSymbol("X");

            playerTwo.setName(CheckGamersNames.getPlayersName("Введите имя второго игрока:"));
            playerTwo.setId("2");
            playerTwo.setSymbol("O");
        } else {
            playerOne = Root.players.get(0);
            playerTwo = Root.players.get(1);
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
            parsingXml.parse(playerOne, playerTwo, moves);
        }
        parsingJson.parse(playerOne, playerTwo, moves);
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