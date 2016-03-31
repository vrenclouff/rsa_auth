package main.java.view;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * Created by lukas_cerny on 30. 3. 2016.
 */
public class AboutController {

    private Stage dialogStage;

    @FXML
    private void initialize() {
        
    }

    /**
     * Sets the stage of this dialog.
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Called when the user clicks cancel.
     */
    @FXML
    private void handleCancel() {
        dialogStage.close();
    }
}
