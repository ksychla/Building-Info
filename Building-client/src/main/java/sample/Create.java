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

    private void changeSceneTo(String file){    // TODO: Change to static method somewhere
        Stage stage = (Stage) borderP.getScene().getWindow();
        try{
            Parent root = FXMLLoader.load(getClass().getResource(file));
            double width = borderP.getWidth();
            double height = borderP.getHeight();
            Scene scene = new Scene(root, width, height);
            stage.setScene(scene);
            stage.show();
        }catch (IOException ignored){ }
    }

    @FXML
    public void plusButton(){
        changeSceneTo("/addRoom.fxml");
    }
}
