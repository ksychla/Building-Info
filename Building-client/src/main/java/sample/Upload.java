package sample;

import Building_Info.BuildingComponent;
import Utils.JsonParser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.FileChooser;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class Upload {
    private double height;
    private double width;

    @FXML
    public BorderPane uploadBorder;
    @FXML
    public ImageView buildingImage;
    @FXML
    public Label fileLabel;
    private JsonParser jsonParser;
    private BuildingComponent building;
    private boolean goodFile = false;

    @FXML
    public void initialize(){
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        width = primaryScreenBounds.getWidth() * 0.85;
        height = primaryScreenBounds.getHeight() * 0.85;
        double h = 802;
        double w = 406 * 0.6 * height / h;
        buildingImage.setFitHeight(height * 0.6);
        buildingImage.setFitWidth(w);
    }

    public Upload(){
        jsonParser = new JsonParser();
    }

    private void wrongInput(){
        fileLabel.setText("Wrong input!");
        fileLabel.getStyleClass().clear();
        fileLabel.getStyleClass().add("wrongLabel");
    }

    private void correctInput(String file){
        fileLabel.setText(file);
        fileLabel.getStyleClass().clear();
        fileLabel.getStyleClass().add("goodLabel2");
    }

    @FXML
    public void addFile(){
        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage) uploadBorder.getScene().getWindow();
        File selectedFile = fileChooser.showOpenDialog(stage);
        try {
            building = jsonParser.loadJson(selectedFile.getAbsolutePath());
        }catch (Exception ignored){
            wrongInput();
            goodFile = false;
        }
        if(building == null){
            wrongInput();
            goodFile = false;
        }else{
            correctInput(selectedFile.getName());
            goodFile = true;
        }
    }

    @FXML
    public void uploadFile(){
        if (goodFile){
            jsonParser.saveJson(building, "Building" + Create.newIndex() + ".json");
            returnTo();
        }
    }

    public void returnTo() {
        Main.changeSceneTo(new Controller(), uploadBorder, "/sample.fxml");
    }
}
