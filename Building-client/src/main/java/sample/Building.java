package sample;

import Building_Info.BuildingComponent;
import Building_Info.BuildingComposite;
import Utils.JsonParser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class Building {
    @FXML
    public BorderPane borderP;
    @FXML
    public Label buildingLabel;
    @FXML
    public HBox floorHBox;
    @FXML
    public Label surfaceLabel, cubatureLabel, heatingLabel, wattageLabel;
    private Evaluate evaluate;
    private BuildingComposite building;
    private String buildingName;
    private JsonParser jsonParser;

    public Building(String file, Evaluate evaluate){
        this.evaluate = evaluate;
        this.buildingName = file.substring(0, file.length()-5);
        jsonParser = new JsonParser();
        building = (BuildingComposite) jsonParser.loadJson("out/"+file);
    }

    @FXML
    public void initialize(){
        buildingLabel.setText(buildingName);
        for(BuildingComponent floor : building.getBuildingComponents()){
            Button f = new Button(floor.getName());
            f.getStyleClass().add("element");
            f.setOnAction(e->gotoFloor((BuildingComposite) floor));
            floorHBox.getChildren().add(f);
        }
        try {
            surfaceLabel.setText(getFeature("surface", null, null));
            cubatureLabel.setText(getFeature("cubature", null, null));
            heatingLabel.setText(getFeature("heating", null, null));
            wattageLabel.setText(getFeature("wattage", null, null));
        }catch (IOException ignored){
            System.out.println("Could not set features");
        }
    }

    private void gotoFloor(BuildingComposite floor){
        Main.changeSceneTo(new Floor(this, floor), borderP, "/building.fxml");
    }

    @FXML
    public void returnTo(){
        Main.changeSceneTo(evaluate, borderP, "/evaluate.fxml");
    }

    public String getFeature(String which, Integer floorIdx, Integer roomIdx) throws IOException {
        String buildingJson = jsonParser.getStringFromJson(buildingName+".json");
        String value = "";  // TODO: Call REST to get values
        String unit;
        switch (which){
            case "surface":
                unit = "m^2";
                break;
            case "cubature":
                unit = "m^3";
                break;
            case "wattage":
                unit = "W";
                break;
            case "heating":
                unit = "J";
                break;
            default:
                unit = "";
                break;
        }
        return value + unit;
    }
}
