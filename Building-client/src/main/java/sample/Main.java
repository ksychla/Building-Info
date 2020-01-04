package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("/sample.fxml"));
        primaryStage.setTitle("Building Info");
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        double width = primaryScreenBounds.getWidth() * 0.85;
        double height = primaryScreenBounds.getHeight() * 0.85;
        primaryStage.setScene(new Scene(root, width, height));
        primaryStage.show();
    }

    public static void changeSceneTo(BorderPane borderP, String file){    // TODO: Change to static method somewhere
        Stage stage = (Stage) borderP.getScene().getWindow();
        try{
            Parent root = FXMLLoader.load(Main.class.getResource(file));
            double width = borderP.getWidth();
            double height = borderP.getHeight();
            Scene scene = new Scene(root, width, height);
            stage.setScene(scene);
            stage.show();
        }catch (IOException ignored){ }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
