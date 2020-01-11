package sample;

import Building_Info.BuildingComposite;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

public class Floor {
    @FXML
    public Label floorLabel;
    @FXML
    public BorderPane borderP;
    private Building building;
    private BuildingComposite floor;

    public Floor(Building building, BuildingComposite floor){
        this.building = building;
        this.floor = floor;
    }

    @FXML
    public void initialize(){
        floorLabel.setText(floor.getName());
    }

    @FXML
    public void returnTo(){
        Main.changeSceneTo(building, borderP, "/building.fxml");
    }
}
