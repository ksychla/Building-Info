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
    public void createButton(){ Main.changeSceneTo(new Create(), borderP, "/create.fxml"); }

    @FXML
    public void uploadButton(){ Main.changeSceneTo(new Upload(), borderP, "/upload.fxml"); }

    @FXML
    public void evaluateButton(){ Main.changeSceneTo(new Evaluate(), borderP, "/evaluate.fxml"); }
}
