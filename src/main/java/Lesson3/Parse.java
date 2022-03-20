package Lesson3;


import Lesson3.logic.XmlReader.Move;
import Lesson3.logic.XmlReader.Player;

import java.util.List;

public interface Parse {

     void parse(Player playerOne, Player playerTwo, List<Move> moves) throws Exception;
}
