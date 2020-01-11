package sample;

import Building_Info.BuildingComponent;
import Building_Info.BuildingComposite;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class addFloor {
    @FXML
    public BorderPane borderP;
    @FXML
    public HBox floorHbox;
    private Create create;
    private BuildingComposite floor;

    public BuildingComposite getFloor(){ return floor; }

    public int getIdx(){
        return create.getIdx();
    }

    public addFloor(Create create){
        this.create = create;
        floor = new BuildingComposite(create.getIdx(), "floor "+(create.getBuilding().GetChildCount()+1));
    }

    @FXML
    public void initialize(){
        for(BuildingComponent room : floor.getBuildingComponents()){
            Button f = new Button(room.getName());
            f.getStyleClass().add("element");
            floorHbox.getChildren().add(f);
        }
    }

    @FXML
    public void save(){
        create.getBuilding().AddChild(floor);
        returnTo();
    }

    @FXML
    public void returnTo() {
        Main.changeSceneTo(create, borderP, "/create.fxml");
    }

    @FXML
    public void plusButton() {
        Main.changeSceneTo(new addRoom(this), borderP, "/addRoom.fxml");
    }
}
