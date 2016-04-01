package view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.LocateString;

import java.io.IOException;

/**
 * Created by lukas_cerny on 30. 3. 2016.
 */
public class RootController {

    @FXML
    private ImageView client1_status;

    @FXML
    private ImageView client2_status;

    private Stage primaryStage;

    @FXML
    private void initialize() {
        changeStatus(client1_status, false);
        changeStatus(client2_status, false);
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
    private void connect(ActionEvent event){
        System.out.println("Connect to server!!!");
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
        dialogStage.setScene(new Scene(page));

        AboutController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        dialogStage.showAndWait();
    }

    @FXML
    private void showEdit(ActionEvent event){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLTemplates.EDIT);
        AnchorPane page = null;
        try {
            page = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage dialogStage = new Stage();
        dialogStage.setTitle(LocateString.getValue("title.edit"));
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        dialogStage.setScene(new Scene(page));

        EditClientController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        dialogStage.showAndWait();
    }

    private void changeStatus(ImageView client, boolean status){
        String image = "/images/";
        image += status ? "green.png" : "red.png";
        client.setImage(new Image(image));
    }
}
