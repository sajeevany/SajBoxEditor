package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML private BorderPane root;
    @FXML private StackPane stackPane;
    @FXML private ScrollPane mainScrollPane;
    @FXML private ImageView baseImagePane;
    @FXML private AnchorPane boxPane;

    @FXML private Label zoomSliderLabel;
    @FXML private Slider zoomSilder;

    private Stage primaryStage;

    //initialize zoom slider + label relationship
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        zoomSilder.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {

                zoomSliderLabel.setText("Zoom " + newValue.intValue() + "%");
            }
        });
    }

    @FXML protected void  handleFileLoadSequence(ActionEvent event)
    {
        //load base tiff/box pair
        FileLoader FL = new FileLoader("Load TIFF File", primaryStage, new Stage());
        FL.loadImageFile(baseImagePane);

    }



}
