package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.File;
import java.util.Arrays;

public class Evaluate {
    @FXML
    public BorderPane borderP;
    @FXML
    public VBox buildingsVBox;

    @FXML
    public void initialize(){
        File folder = new File("out/");
        File[] files = folder.listFiles();
        Arrays.sort(files);
        for(File f : files){
            if(!f.getName().substring(f.getName().length()-5).equals(".json"))
                continue;
            Button button = new Button(f.getName().substring(0, f.getName().length()-5));
            button.getStyleClass().add("buildingButton");
            button.setOnAction(e->gotoBuilding(f.getName()));
            buildingsVBox.getChildren().add(button);
        }
    }

    public void gotoBuilding(String file){
        Main.changeSceneTo(new Building(file, this), borderP, "/building.fxml");
    }

    public void returnTo() {
        Main.changeSceneTo(new Controller(), borderP, "/sample.fxml");
    }
}
