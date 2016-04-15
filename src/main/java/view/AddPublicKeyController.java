package view;

import dao.Client;
import dao.KnownHost;
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

    private Client client;
    private Stage primaryStage;

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
        this.primaryStage = dialogStage;
    }

    /**
     * Ukonceni okna na pridavani klicu
     */
    @FXML
    private void handleClose() {
        primaryStage.close();
    }

    /**
     * Pridani verejneho klice
     */
    @FXML
    private void handleSave(){
        client.getKnownHosts().add(new KnownHost(clientName.getText(), clientKey.getText()));
        handleClose();
    }

    /**
     * Nasetovani klienta
     *
     * @param client
     */
    public void setClient(Client client) {
        this.client = client;
    }
}
