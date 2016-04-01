package view;

import dao.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.LocateString;

import java.io.IOException;

/**
 * Created by lukas_cerny on 1. 4. 2016.
 */
public class EditClientController {

    @FXML
    private TextArea publicKey;

    @FXML
    private TextArea privateKey;

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

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleClose() {
        primaryStage.close();
    }

    @FXML
    private void addKey(){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLTemplates.ADD_KEY);
        AnchorPane page = null;
        try {
            page = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage dialogStage = new Stage();
        dialogStage.setTitle(LocateString.getValue("title.addPublicKey"));
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        dialogStage.setScene(new Scene(page));

        AddPublicKeyController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        dialogStage.showAndWait();
    }

    @FXML
    private void removeKey(){
        System.out.println("Remove key!!!!");
    }

    @FXML
    private void generateKeys(){
        System.out.println("Generate keys!!!");
    }
}
