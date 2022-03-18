package Lesson3;

import Lesson3.body.Game;
import Lesson3.logic.DrawCheck;
import Lesson3.logic.GamePlay;
import Lesson3.logic.Logs;
import Lesson3.logic.ParsingXml;
import Lesson3.logic.Users;
import Lesson3.logic.WinCheck;
import Lesson3.logic.XmlReader.Root;

public class LauncherNew {

    public static GamePlay gamePlay;

    public static void main(String[] args) throws Exception {

        gamePlay = new GamePlay();

        if (args.length == 0) {
            new Game(
                    new Users(),
                    new WinCheck(),
                    new DrawCheck(),
                    new Logs(),
                    new ParsingXml(),
                    false
            ).play();
        } else {
            String filename = args[0];
            Root.read(filename);
            new Game(
                    new Users(),
                    new WinCheck(),
                    new DrawCheck(),
                    new Logs(),
                    new ParsingXml(),
                    true
            ).play();
        }

    }

}