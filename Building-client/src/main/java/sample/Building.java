package sample;

import Building_Info.BuildingComponent;
import Building_Info.BuildingComposite;
import Utils.JsonParser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.File;

public class Building {
    @FXML
    public BorderPane borderP;
    @FXML
    public Label buildingLabel;
    @FXML
    public HBox floorHBox;
    private Evaluate evaluate;
    private BuildingComposite building;
    private String buildingName;

    public Building(File file, Evaluate evaluate){
        this.evaluate = evaluate;
        this.buildingName = file.getName().substring(0, file.getName().length()-5);
        JsonParser jsonParser = new JsonParser();
        building = (BuildingComposite) jsonParser.loadJson(file.getName());
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
    }

    private void gotoFloor(BuildingComposite floor){
        Main.changeSceneTo(new Floor(this, floor), borderP, "/floor.fxml");
    }

    @FXML
    public void returnTo(){
        Main.changeSceneTo(evaluate, borderP, "/evaluate.fxml");
    }
}
