package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.ArrayList;

public class Evaluate {
    @FXML
    public BorderPane borderP;
    @FXML
    public VBox buildingsVBox;

    @FXML
    public void initialize(){
        File folder = new File("out/");
        for(File f : folder.listFiles()){
            if(!f.getName().substring(f.getName().length()-5).equals(".json"))
                continue;
            Button button = new Button(f.getName().substring(0, f.getName().length()-5));
            button.getStyleClass().add("buildingButton");
            button.setOnAction(e->gotoBuilding(f));
            buildingsVBox.getChildren().add(button);
        }
    }

    public void gotoBuilding(File file){
        Main.changeSceneTo(new Building(file, this), borderP, "/building.fxml");
    }

    public void returnTo() {
        Main.changeSceneTo(new Controller(), borderP, "/sample.fxml");
    }
}
