package view;

import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * Created by lukas_cerny on 30. 3. 2016.
 */
public class AboutController {

    private Stage dialogStage;

    /**
     * Inicializace komponenty
     */
    @FXML
    private void initialize() {
        
    }

    /**
     * Nastaveni dialogoveho okna
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Ukoncni okna O aplikaci
     */
    @FXML
    private void handleClose() {
        dialogStage.close();
    }
}
