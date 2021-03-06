package sample;

import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

/**
 * Created by Admin on 5/6/2016.
 */
public class FileLoader {

    private FileChooser fileChooser;
    private Button selectButton = new Button("Select Image");
    private Stage stage;
    private Stage primaryStage;

    //[src] https://docs.oracle.com/javafx/2/ui_controls/file-chooser.htm
    public FileLoader(String title, Stage primaryStage, Stage stage)
    {
        fileChooser = new FileChooser();
        fileChooser.setTitle(title);
        this.stage = stage;
        this.primaryStage = primaryStage;
    }

    public void loadImageFile(ImageView basePane)
    {
        //load user selected file
        File file = fileChooser.showOpenDialog(stage);
        if (file != null)
        {
            //user has chosen a file
            //check if tif/tiff/png or else fail

            //load image
            basePane.setImage(new Image("file:" + file.getAbsolutePath()));
        }

    }
}
