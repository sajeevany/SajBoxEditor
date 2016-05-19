package sample;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Slider;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML private StackPane mainStackPane;
    @FXML private ScrollPane mainScrollPane;
    @FXML private ImageView baseImagePane;

    @FXML private Label zoomSliderLabel;
    @FXML private Slider zoomSilder;

    private Stage primaryStage;


    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //initialize zoom slider + label relationship
        zoomSilder.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                zoomSliderLabel.setText("Zoom " + newValue.intValue() + "%");
                mainStackPane.setScaleX((double) newValue.intValue() / 100);
                mainStackPane.setScaleY((double) newValue.intValue() / 100);
            }
        });

        //Adjust scrollpane which encapsulates zoomable region based on zoomslider-induced changes
        mainScrollPane.viewportBoundsProperty().addListener(new ChangeListener<Bounds>() {
            @Override
            public void changed(ObservableValue<? extends Bounds> observable, Bounds oldValue, Bounds newValue) {
                mainScrollPane.setMinSize(newValue.getWidth(), newValue.getHeight());
            }
        });
    }

    @FXML protected void  handleFileLoadSequence(ActionEvent event)
    {
        //load base tiff/box pair
        FileLoader FL = new FileLoader("Load TIFF File", primaryStage, new Stage());
        FL.loadImageFile(baseImagePane);

        //reset slider position/value
        zoomSliderLabel.setText("100%");
        zoomSilder.setValue(100);

    }



}
