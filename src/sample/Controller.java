package sample;

import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Controller {

    @FXML private BorderPane root;
    @FXML private StackPane stackPane;
    @FXML private ScrollPane mainScrollPane;
    //@FXML private AnchorPane baseImagePane;
    @FXML private ImageView baseImagePane;
    @FXML private AnchorPane boxPane;

    private Stage primaryStage;

    @FXML protected void  handleFileLoadSequence(ActionEvent event)
    {

        //load base tiff/box pair
        FileLoader FL = new FileLoader("Load TIFF File", primaryStage, new Stage());
        FL.loadImageFile(baseImagePane);


    }


}
