package Utils;

import Building_Info.BuildingComposite;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class JsonParserTest {
    private JsonParser parser;
    private String testStringRich = new String(
    "{\n" +
            "  \"buildingComponents\": [\n" +
            "    {\n" +
            "      \"buildingComponents\": [\n" +
            "        {\n" +
            "          \"surface\": 10.0,\n" +
            "          \"lampWattage\": 10,\n" +
            "          \"cubature\": 10.0,\n" +
            "          \"heating\": 0.0,\n" +
            "          \"idx\": 3,\n" +
            "          \"name\": \"Poko1\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"surface\": 10.0,\n" +
            "          \"lampWattage\": 10,\n" +
            "          \"cubature\": 10.0,\n" +
            "          \"heating\": 0.0,\n" +
            "          \"idx\": 4,\n" +
            "          \"name\": \"Poko1\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"idx\": 2,\n" +
            "      \"name\": \"Pietro1\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"buildingComponents\": [\n" +
            "        {\n" +
            "          \"surface\": 10.0,\n" +
            "          \"lampWattage\": 10,\n" +
            "          \"cubature\": 10.0,\n" +
            "          \"heating\": 0.0,\n" +
            "          \"idx\": 6,\n" +
            "          \"name\": \"Poko1\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"surface\": 10.0,\n" +
            "          \"lampWattage\": 10,\n" +
            "          \"cubature\": 10.0,\n" +
            "          \"heating\": 0.0,\n" +
            "          \"idx\": 7,\n" +
            "          \"name\": \"Poko1\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"idx\": 5,\n" +
            "      \"name\": \"Pietro2\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"buildingComponents\": [\n" +
            "        {\n" +
            "          \"surface\": 10.0,\n" +
            "          \"lampWattage\": 10,\n" +
            "          \"cubature\": 10.0,\n" +
            "          \"heating\": 0.0,\n" +
            "          \"idx\": 9,\n" +
            "          \"name\": \"Poko1\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"surface\": 10.0,\n" +
            "          \"lampWattage\": 10,\n" +
            "          \"cubature\": 10.0,\n" +
            "          \"heating\": 0.0,\n" +
            "          \"idx\": 10,\n" +
            "          \"name\": \"Poko1\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"idx\": 10,\n" +
            "      \"name\": \"Pietro3\"\n" +
            "    },\n" +
            "    {\n" +
            "      \"buildingComponents\": [\n" +
            "        {\n" +
            "          \"surface\": 10.0,\n" +
            "          \"lampWattage\": 10,\n" +
            "          \"cubature\": 10.0,\n" +
            "          \"heating\": 0.0,\n" +
            "          \"idx\": 12,\n" +
            "          \"name\": \"Poko1\"\n" +
            "        },\n" +
            "        {\n" +
            "          \"surface\": 10.0,\n" +
            "          \"lampWattage\": 10,\n" +
            "          \"cubature\": 10.0,\n" +
            "          \"heating\": 0.0,\n" +
            "          \"idx\": 13,\n" +
            "          \"name\": \"Poko1\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"idx\": 11,\n" +
            "      \"name\": \"Pietro4\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"idx\": 1,\n" +
            "  \"name\": \"Budynek\"\n" +
            "}\n");
    private String testStringBarren = new String(
    "{\n" +
            "  \"buildingComponents\": [\n" +
            "    {\n" +
            "      \"buildingComponents\": [\n" +
            "        {\n" +
            "          \"surface\": 25.0,\n" +
            "          \"lampWattage\": 10,\n" +
            "          \"cubature\": 10.0,\n" +
            "          \"heating\": 0.0,\n" +
            "          \"idx\": 4,\n" +
            "          \"name\": \"Poko1\"\n" +
            "        }\n" +
            "      ],\n" +
            "      \"idx\": 2,\n" +
            "      \"name\": \"Pietro1\"\n" +
            "    }\n" +
            "  ],\n" +
            "  \"idx\": 1,\n" +
            "  \"name\": \"BudynekTestowy\"\n" +
            "}\n");

    @Before
    public void setup(){
        parser = new JsonParser();
    }
    @Test
    public void loadJsonBuildingWithManyRooms() {assertEquals(80, parser.loadJson("test.json").GetSurface(), 0.001); }

    @Test
    public void loadJsonBarrenBuilding() {assertEquals(25, parser.loadJson("testsingle.json").GetSurface(), 0.001); }

    @Test
    public void saveFromStringBuildingWithManyRooms() {
        try {
            assertEquals(80, parser.loadJson(parser.saveFromString(testStringRich).getName()).GetSurface(), 0.001);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void saveFromStringBarrenBuilding() {
        try {
            assertEquals(25, parser.loadJson(parser.saveFromString(testStringBarren).getName()).GetSurface(), 0.001);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void getStringFromJsonRich(){
        try {
            assertEquals(testStringRich, parser.getStringFromJson("test.json"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @Test
    public void getStringFromJsonBarren(){
        try {
            assertEquals(testStringBarren, parser.getStringFromJson("testsingle.json"));
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}