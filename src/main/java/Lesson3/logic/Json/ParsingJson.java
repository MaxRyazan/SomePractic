package Lesson3.logic.Json;

import Lesson3.Parse;
import Lesson3.body.Game;
import Lesson3.logic.GamePlay;
import Lesson3.logic.GameResult;
import Lesson3.logic.XmlReader.Move;
import Lesson3.logic.XmlReader.Player;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileOutputStream;
import java.util.List;


public class ParsingJson implements Parse {

   @Override
    public void parse(Player player1, Player player2, List<Move> moves) {

       GamePlay gamePlay = new GamePlay(Game.playerOne,Game.playerTwo, Game.moves);

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
       System.out.println(json);

       try(FileOutputStream outputStream = new FileOutputStream("Gameplay.json")) {
           outputStream.write(json.getBytes());
       } catch (Exception e) {
           e.printStackTrace();
       }

    }
}
