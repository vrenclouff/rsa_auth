package main.java.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import main.java.utils.LocateString;

import java.io.IOException;

/**
 * Created by lukas_cerny on 30. 3. 2016.
 */
public class RootController {

    private Stage primaryStage;

    @FXML
    private void initialize() {

    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.primaryStage = dialogStage;
    }

    @FXML
    private void close(ActionEvent event){
        System.out.println("Close app!!!!");
        Platform.exit();
    }

    @FXML
    private void reset(ActionEvent event){
        System.out.println("Reset data!!!!");
    }

    @FXML
    private void showAbout(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLTemplates.ABOUT);
        AnchorPane page = null;
        try {
            page = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage dialogStage = new Stage();
        dialogStage.setTitle(LocateString.getValue("title.about"));
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        AboutController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        dialogStage.showAndWait();
    }
}