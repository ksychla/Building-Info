package sample;

import Building_Info.Room;
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
        Main.changeSceneTo(floor, borderP, "/addFloor.fxml");
    }

    private addFloor floor;
    private Room room;

    public addRoom(addFloor floor){
        this.floor = floor;
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

    private boolean isExit(VBox vbox, TextField textField, boolean exit){
        if(isNumber(textField.getText())){
            wrong(vbox);
            return true;
        }else{
            right(vbox);
        }
        return exit;
    }

    @FXML
    public void save(){
        boolean exit = false;
        if(nameText.getText().isEmpty()){   // TODO: extract to method
            exit = true;
            wrong(name);
        }else{
            right(name);
        }
        exit = isExit(surface, surText, exit);
        exit = isExit(cubature, cubText, exit);
        exit = isExit(wattage, watText, exit);
        exit = isExit(heating, heaText, exit);
        if(exit)
            return;
        floor.getFloor().AddChild(new Room(floor.getIdx(),
                nameText.getText(),
                Float.parseFloat(surText.getText()),
                Integer.parseInt(watText.getText()),
                Float.parseFloat(cubText.getText()),
                Float.parseFloat(heaText.getText())));
        returnTo();
    }
}
