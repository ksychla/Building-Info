package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Controller {
    @FXML
    public BorderPane borderP;

    @FXML
    public void createButton(){ Main.changeSceneTo(borderP, "/create.fxml"); }

    @FXML
    public void uploadButton(){ Main.changeSceneTo(borderP, "/upload.fxml"); }

    @FXML
    public void evaluateButton(){ Main.changeSceneTo(borderP, "/evaluate.fxml"); }
}
