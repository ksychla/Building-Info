package sample;

import Building_Info.BuildingComponent;
import Building_Info.BuildingComposite;
import Utils.JsonParser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

import java.io.File;
import java.io.IOException;

public class Create {
    @FXML
    public BorderPane borderP;
    @FXML
    public HBox buildingHbox;
    private BuildingComposite building;
    private JsonParser jsonParser;
    private int idx;

    public int getIdx(){
        return idx++;
    }

    public BuildingComposite getBuilding(){ return building; }

    public static int newIndex(){
        int num = 0;
        try{
            File file = null;
            for(int i=1;i<1000;i++){
                file = new File("out/Building"+i+".json");
                if(file.createNewFile()){
                    num = i;
                    break;
                }
            }
            file.delete();
        }catch (IOException ignored) {
            System.out.println("Did not handle indexing well");
        }
        return num;
    }

    public Create(){
        idx = 1;
        building = new BuildingComposite(getIdx(), "Building" + newIndex());
        jsonParser = new JsonParser();
    }

    @FXML
    public void initialize(){
        for(BuildingComponent floor : building.getBuildingComponents()){
            Button f = new Button(floor.getName());
            f.getStyleClass().add("element");
            buildingHbox.getChildren().add(f);
        }
    }

    @FXML
    public void save(){
        jsonParser.saveJson(building, building.getName() + ".json");
        returnTo();
    }

    @FXML
    public void returnTo(){
        Main.changeSceneTo(new Controller(), borderP, "/sample.fxml");
    }

    @FXML
    public void plusButton(){
        Main.changeSceneTo(new addFloor(this), borderP, "/addFloor.fxml");
    }
}
