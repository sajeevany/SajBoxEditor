package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javax.swing.*;

/**
 * Created by Admin on 5/6/2016.
 */
public class AlertBox {

    public static void display(String displayMessage)
    {
        //Create stage that blocks
        Stage popUpStage = new Stage();
        popUpStage.initModality(Modality.APPLICATION_MODAL);

        //Set alert box properties. Includes. Message and Confirmation button
        StackPane sP = new StackPane();
        Text alertMessage = new Text(displayMessage);
        Button closeButton = new Button("Understood");
        closeButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                popUpStage.close();
            }
        });

        //Add the properties to the VBox
        sP.getChildren().addAll(alertMessage, closeButton);
        sP.setAlignment(alertMessage, Pos.TOP_CENTER);
        sP.setAlignment(closeButton, Pos.BOTTOM_CENTER);

        //Set scene that is to be displayed
        Scene alertScene = new Scene(sP,100,50);
        popUpStage.setScene(alertScene);
        popUpStage.show();


    }
}
