package Lesson3;

import Lesson3.body.Game;
import Lesson3.logic.GamePlay;
import Lesson3.logic.Json.ParsingJson;
import Lesson3.logic.Xml.ParsingXml;


public class LauncherNew {

public static GamePlay gamePlay;
public static ParsingJson parsingJson;
public static ParsingXml parsingXml;
public enum ConvertType{

    XML,
    JSON

}

    public static void main(String[] args) throws Exception {
        gamePlay = new GamePlay();
        parsingJson = new ParsingJson();
        parsingXml = new ParsingXml();


        String convertTypeString = args[0].replace("-", "").toUpperCase();
        ConvertType convertType = ConvertType.valueOf(convertTypeString);

        if (args.length == 1) {
            new Game(false, convertType).play();
        } else {
            String filename = args[1];

            String [] input = filename.split(".");
            for (int i = 0; i < input.length; i++) {

                if (input[1].equals("json")) {
                    parsingJson.read(filename);
                } else {
                    parsingXml.read(filename);
                }
            }

            new Game(true, convertType).play();
        }
    }
}