package Lesson3;

import Lesson3.body.Game;
import Lesson3.logic.GamePlay;
import Lesson3.logic.Json.JsonRoot;
import Lesson3.logic.Json.ParsingJson;
import Lesson3.logic.Json.ReadJson;
import Lesson3.logic.XmlReader.Root;



public class LauncherNew {

public static GamePlay gamePlay;
public static ParsingJson parsingJson;

    public static void main(String[] args) throws Exception {
        gamePlay = new GamePlay();
        parsingJson = new ParsingJson();

        if (args.length == 0) {
            new Game(false).play();
        } else {
            String filename = args[0];

            Root.read(filename);

            new Game(true).play();
        }

        ReadJson readJson = new ReadJson();
        JsonRoot jsonRoot = readJson.read("Gameplay.json");
        System.out.println(jsonRoot.toString());


    }
}