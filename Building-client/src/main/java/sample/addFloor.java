package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class addFloor {
    @FXML
    public BorderPane borderP;

    @FXML
    public void returnTo() {
        Main.changeSceneTo(borderP, "/create.fxml");
    }

    @FXML
    public void plusButton() {
        Main.changeSceneTo(borderP, "/addRoom.fxml");
    }
}
