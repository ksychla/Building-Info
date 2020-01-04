package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class Evaluate {
    @FXML
    public BorderPane borderP;

    public void returnTo() {
        Main.changeSceneTo(borderP, "/sample.fxml");
    }
}
