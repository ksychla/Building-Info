package Utils;

import Building_Info.BuildingComponent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;

public class JsonParser {
    public void saveJson(BuildingComponent building, String json_name){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            FileWriter parser = new FileWriter("src/"+json_name);

            gson.toJson(building,parser);
            parser.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public BuildingComponent loadJson(String json_name){
        Gson gson = new GsonBuilder().registerTypeAdapter(BuildingComponent.class, new BuildingDeserializer()).create();
        BuildingComponent building = null;

        try {
            Reader jsonreader = new FileReader("src/"+json_name);
            building = gson.fromJson(jsonreader, BuildingComponent.class);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return building;

    }
}
