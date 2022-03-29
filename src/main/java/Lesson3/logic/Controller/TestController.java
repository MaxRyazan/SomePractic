package Lesson3.logic.Controller;


import Lesson3.LauncherNew;
import Lesson3.body.Game;
import Lesson3.logic.GamePlay;
import Lesson3.logic.GameResult;
import Lesson3.logic.Json.JsonRoot;
import Lesson3.logic.Json.ParsingJson;
import Lesson3.logic.Xml.ParsingXml;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import static Lesson3.body.Game.*;


@RestController
@RequestMapping("/api")
public class TestController {
    GamePlay gamePlay;
    ParsingJson parsingJson;
    ParsingXml parsingXml;

    GameResult gameResult;

    @GetMapping(value = "/myTestController", produces = MediaType.APPLICATION_JSON_VALUE)
    public JsonRoot myTestController(@RequestParam String filename) throws Exception {
        gamePlay = new GamePlay();
        parsingJson = new ParsingJson();
        parsingXml = new ParsingXml();
        gameResult = new GameResult();

        JsonRoot jsonRoot = parsingJson.read(filename);
        new Game(true, LauncherNew.ConvertType.JSON).play(jsonRoot);

        return jsonRoot;
    }
}

