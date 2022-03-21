package Lesson3.logic.Json;


import com.google.gson.Gson;
import java.io.FileReader;

public class ReadJson {

   // private static final String file = "Gameplay.json";

public JsonRoot read(final String file) throws Exception {

    FileReader reader = new FileReader(file);
    Gson gson = new Gson();

    return gson.fromJson(reader, JsonRoot.class);
}

}
