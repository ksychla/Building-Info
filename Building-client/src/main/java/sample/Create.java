package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Create {
    @FXML
    public BorderPane borderP;

    @FXML
    public void returnTo(){
        Main.changeSceneTo(borderP, "/sample.fxml");
    }

    @FXML
    public void plusButton(){
        Main.changeSceneTo(borderP, "/addFloor.fxml");
    }
}
