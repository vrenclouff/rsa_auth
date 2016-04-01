package view;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by lukas_cerny on 1. 4. 2016.
 */
public class AddPublicKeyController {

    @FXML
    private TextField clientName;

    @FXML
    private TextField clientKey;

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
    private void handleSave(){
        System.out.println("Name: "+clientName.getText());
        System.out.println("Public key: "+clientKey.getText());
    }
}
