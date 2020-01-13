package sample;

import Building_Info.BuildingComponent;
import Building_Info.BuildingComposite;
import Building_Info.Room;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class Floor {
    @FXML
    public Label buildingLabel;
    @FXML
    public BorderPane borderP;
    @FXML
    public HBox floorHBox;
    @FXML
    public Label surfaceLabel, cubatureLabel, heatingLabel, wattageLabel;
    private Building building;
    private BuildingComposite floor;

    public Floor(Building building, BuildingComposite floor){
        this.building = building;
        this.floor = floor;
    }

    @FXML
    public void initialize(){
        buildingLabel.setText(floor.getName());
        for(BuildingComponent room : floor.getBuildingComponents()){
            Button f = new Button(room.getName());
            f.getStyleClass().add("element");
            f.setOnAction(e->gotoRoom((Room) room));
            floorHBox.getChildren().add(f);
        }
        try {
            surfaceLabel.setText(building.getFeature("surface", floor.getIdx(), null));
            cubatureLabel.setText(building.getFeature("cubature", floor.getIdx(), null));
            heatingLabel.setText(building.getFeature("heating", floor.getIdx(), null));
            wattageLabel.setText(building.getFeature("wattage", floor.getIdx(), null));
        }catch (IOException ignored){
            System.out.println("Could not set features");
        }
    }

    private void gotoRoom(Room room){
        Main.changeSceneTo(new RoomInfo(this, room, building, floor), borderP, "/room.fxml");
    }

    @FXML
    public void returnTo(){
        Main.changeSceneTo(building, borderP, "/building.fxml");
    }
}
