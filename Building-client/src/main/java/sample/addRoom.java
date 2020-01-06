package sample;

import javafx.fxml.FXML;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Screen;

public class addRoom {
    private double width;
    private double height;

    @FXML
    public BorderPane borderP;

    @FXML
    public ImageView roomImage;

    @FXML
    public VBox name;

    @FXML
    public VBox surface;

    @FXML
    public VBox cubature;

    @FXML
    public VBox wattage;

    @FXML
    public VBox heating;

    @FXML
    public TextField nameText;

    @FXML
    public TextField surText;

    @FXML
    public TextField cubText;

    @FXML
    public TextField watText;

    @FXML
    public TextField heaText;

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

    private boolean isNumber(String s){
        return !s.matches("[0-9]+\\.?[0-9]*");
    }

    private void wrong(VBox field){
        while(field.getChildren().get(1).getStyleClass().remove("goodLabel"));
        field.getChildren().get(1).getStyleClass().add("wrongLabel");
    }

    private void right(VBox field){
        while(field.getChildren().get(1).getStyleClass().remove("wrongLabel"));
        field.getChildren().get(1).getStyleClass().add("goodLabel");
    }

    @FXML
    public void save(){
        if(nameText.getText().isEmpty()){
            wrong(name);
        }else{
            right(name);
        }
        if(isNumber(surText.getText())){
            wrong(surface);
        }else{
            right(surface);
        }
        if(isNumber(cubText.getText())){
            wrong(cubature);
        }else{
            right(cubature);
        }
        if(isNumber(watText.getText())){
            wrong(wattage);
        }else{
            right(wattage);
        }
        if(isNumber(heaText.getText())){
            wrong(heating);
        }else{
            right(heating);
        }
    }
}
