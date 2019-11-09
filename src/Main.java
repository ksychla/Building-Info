import Building_Info.*;
import Utils.JsonParser;

/**
 * Main class for running the program
 * Will work with the REST api later
 */
public class Main {
    public static void main(String[] args){
        BuildingComponent building = BuildingComponent.GetExamplaryBuilding();
        BuildingComponent test;
        JsonParser parser = new JsonParser();

        parser.saveJson(building, "building.json");
        test = parser.loadJson("building.json");

        test.printInfo();


    }
}
