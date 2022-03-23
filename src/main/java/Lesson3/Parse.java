package Lesson3;


import Lesson3.logic.Json.JsonRoot;
import Lesson3.logic.Xml.Move;
import Lesson3.logic.Xml.Player;
import java.util.List;

public interface Parse {


    JsonRoot read(final String file) throws Exception;

    void parse(Player player1, Player player2, List<Move> moves) throws Exception;

}
