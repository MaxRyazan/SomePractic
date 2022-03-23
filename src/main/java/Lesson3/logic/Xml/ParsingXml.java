package Lesson3.logic.Xml;

import Lesson3.Parse;
import Lesson3.logic.Json.JsonRoot;
import java.util.ArrayList;
import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;



public class ParsingXml implements Parse {

    @Override
    public JsonRoot read(final String filename) throws Exception {
        File file = new File(filename);
        Document doc;
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        doc = dbf.newDocumentBuilder().parse(file);

        JsonRoot jsonRoot = new JsonRoot();
        Player playerOne = new Player();
        Player playerTwo = new Player();
        List<Move> moves = new ArrayList<>();


        NodeList playerElements = doc.getDocumentElement().getElementsByTagName("PLayer");

        fillPlayerInfo(playerOne, playerElements.item(0));
        fillPlayerInfo(playerTwo, playerElements.item(1));

        jsonRoot.setPlayerOne(playerOne);
        jsonRoot.setPlayerTwo(playerTwo);


        NodeList movesElements = doc.getDocumentElement().getElementsByTagName("Step");

        for (int i = 0; i < movesElements.getLength(); i++) {
            Node move = movesElements.item(i);
            NamedNodeMap attributes = move.getAttributes();

            moves.add(new Move(Integer.parseInt(attributes.getNamedItem("playerId").getNodeValue()),
                    Integer.parseInt(move.getTextContent()),
                    Integer.parseInt(attributes.getNamedItem("num").getNodeValue())
            ));
        }
        for (Move value : moves) {
            System.out.printf("Информации о ходах: номер хода - %s, ID игрока - %s, координата хода - %s %n",
                    value.getNum(), value.getPlayerId(), value.getCoordinate()
            );
        }

        jsonRoot.setMoves(moves);

        return jsonRoot;
    }

    private void fillPlayerInfo(Player player, Node playerNode) {
        NamedNodeMap attributes = playerNode.getAttributes();

        player.setId(attributes.getNamedItem("id").getNodeValue());
        player.setName(attributes.getNamedItem("name").getNodeValue());
        player.setSymbol(attributes.getNamedItem("symbol").getNodeValue());

        System.out.printf("Информации о игроках: ID игрока - %s, имя игрока - %s, символ игрока - %s %n",
                player.getId(), player.getName(), player.getSymbol());
    }

    public void parse(Player playerOne, Player playerTwo, List<Move> moves) throws ParserConfigurationException, FileNotFoundException, TransformerException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document document = builder.newDocument();

        Element root = document.createElement("Gameplay");
        Element player = document.createElement("PLayer");
        Element player2 = document.createElement("PLayer");
        Element game = document.createElement("Game");
        Element gameResult = document.createElement("GameResult");

        document.appendChild(root);
        root.appendChild(player);
        root.appendChild(player2);

        player.setAttribute("id", playerOne.getId());
        player.setAttribute("name", playerOne.getName());
        player.setAttribute("symbol", playerOne.getSymbol());


        player2.setAttribute("id", playerTwo.getId());
        player2.setAttribute("name", playerTwo.getName());
        player2.setAttribute("symbol", playerTwo.getSymbol());

        root.appendChild(game);

        for (Move value : moves) {
            Element step = document.createElement("Step");
            step.setAttribute("num", Integer.toString(value.getNum()));
            step.setAttribute("playerId", Integer.toString(value.getPlayerId()));
            Text text = document.createTextNode(Integer.toString(value.getCoordinate()));
            step.appendChild(text);
            game.appendChild(step);
        }
        if(playerOne.isWinner()) {
            gameResult.setAttribute("playerId", playerOne.getId());
            gameResult.setAttribute("WINNER", playerOne.getName());
            gameResult.setAttribute("symbol", playerOne.getSymbol());
            root.appendChild(gameResult);
        }
        else if (playerTwo.isWinner()) {
            gameResult.setAttribute("playerId", playerTwo.getId());
            gameResult.setAttribute("WINNER", playerTwo.getName());
            gameResult.setAttribute("symbol", playerTwo.getSymbol());
            root.appendChild(gameResult);
        }
        else {
            gameResult.setTextContent("Its Draw!");
            root.appendChild(gameResult);
        }
        Transformer t = TransformerFactory.newInstance().newTransformer();
        t.setOutputProperty(OutputKeys.INDENT, "yes");
        t.transform(new DOMSource(document), new StreamResult(new FileOutputStream("testInXML.xml")));
    }
}