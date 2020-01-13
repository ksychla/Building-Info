package sample;

import Building_Info.BuildingComponent;
import Building_Info.Room;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class RoomInfo {
    @FXML
    public BorderPane borderP;
    @FXML
    public Label roomLabel;
    @FXML
    public Label surface, cubature, heating, wattage;
    private Floor floorView;
    private Room room;
    private Building building;
    private BuildingComponent floor;

    public RoomInfo(Floor floorView, Room room, Building building, BuildingComponent floor){
        this.floorView = floorView;
        this.room = room;
        this.building = building;
        this.floor = floor;
    }

    @FXML
    public void initialize(){
        roomLabel.setText(room.getName());
        try {
            surface.setText(building.getFeature("surface", floor.getIdx(), room.getIdx()));
            cubature.setText(building.getFeature("cubature", floor.getIdx(), room.getIdx()));
            heating.setText(building.getFeature("heating", floor.getIdx(), room.getIdx()));
            wattage.setText(building.getFeature("wattage", floor.getIdx(), room.getIdx()));
        }catch (IOException ignored){
            System.out.println("Could not set features");
        }
    }

    @FXML
    public void returnTo(){
        Main.changeSceneTo(floorView, borderP, "/building.fxml");
    }
}
