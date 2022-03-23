package Lesson3.logic.Json;

import Lesson3.Parse;

import Lesson3.logic.GamePlay;
import Lesson3.logic.GameResult;
import Lesson3.logic.Xml.Move;
import Lesson3.logic.Xml.Player;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.util.List;

import static Lesson3.body.Game.*;


public class ParsingJson implements Parse {

    @Override
    public JsonRoot read(final String file) throws Exception {

        FileReader reader = new FileReader(file);
        Gson gson = new Gson();

        return gson.fromJson(reader, JsonRoot.class);
    }

    @Override
    public void parse(Player player1, Player player2, List<Move> move) {

        GamePlay gamePlay = new GamePlay(playerOne,playerTwo, moves);

        GameResult gameResult = new GameResult();

        if(player1.isWinner()) {
            gameResult.setPlayer(player1);
        } else if(player2.isWinner()) {
            gameResult.setPlayer(player2);
        } else {
            gameResult.initDrawString();
        }

        gamePlay.setGameResult(gameResult);

        final Gson GSON = new GsonBuilder().
                setPrettyPrinting().
                excludeFieldsWithoutExposeAnnotation().
                create();

        String json = GSON.toJson(gamePlay);

        try(FileOutputStream outputStream = new FileOutputStream("Gameplay.json")) {
            outputStream.write(json.getBytes());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
