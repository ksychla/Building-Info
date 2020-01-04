package sample;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;

public class addRoom {
    private double width;
    private double height;

    @FXML
    public BorderPane borderP;

    @FXML
    public ImageView roomImage;

    @FXML
    public void returnTo(){
        Main.changeSceneTo(borderP, "/addFloor.fxml");
    }

    @FXML
    public void initialize(){
        Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
        width = primaryScreenBounds.getWidth() * 0.85;
        height = primaryScreenBounds.getHeight() * 0.85;
        double h = 526;
        double w = 531 * 0.6 * height / h;
        roomImage.setFitHeight(height * 0.6);
        roomImage.setFitWidth(w);
    }
}
