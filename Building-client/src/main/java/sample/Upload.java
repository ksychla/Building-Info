package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Screen;

public class Upload {
    private double height;
    private double width;

    @FXML
    public BorderPane uploadBorder;

    @FXML
    public ImageView buildingImage;

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

    public void returnTo() {
        Main.changeSceneTo(new Controller(), uploadBorder, "/sample.fxml");
    }
}
