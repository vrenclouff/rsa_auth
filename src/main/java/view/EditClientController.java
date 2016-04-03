package view;

import app.KeyGenerator;
import dao.Client;
import dao.KnownHost;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
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

    @FXML
    private TableView<KnownHost> knownHost;

    @FXML
    private TableColumn<KnownHost, String> nameColumn;
    @FXML
    private TableColumn<KnownHost, String> publicKeyColumn;

    private Stage primaryStage;
    private Client client;

    @FXML
    private void initialize() {
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        publicKeyColumn.setCellValueFactory(cellData -> cellData.getValue().keyProperty());
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
        FXMLLoader loader = new FXMLLoader(FXMLTemplates.ADD_KEY);
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
        controller.setClient(client);
        controller.setDialogStage(dialogStage);
        dialogStage.showAndWait();
    }

    @FXML
    private void removeKey(){
        int selectedIndex = knownHost.getSelectionModel().getSelectedIndex();
        if (selectedIndex >= 0) {
            knownHost.getItems().remove(selectedIndex);
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(primaryStage);
            alert.setTitle(LocateString.getValue("alert.warning.title.noSelection"));
            alert.setHeaderText(LocateString.getValue("alert.warning.header.noSelection"));
            alert.setContentText(LocateString.getValue("alert.warning.content.noSelection"));
            alert.showAndWait();
        }
    }

    @FXML
    private void generateKeys(){
        KeyGenerator generator = new KeyGenerator();
        this.client.setPublicKey(generator.getPublicKey());
        this.client.setPrivateKey(generator.getPrivateKey());
        updateClient();
    }

    public void setClient(Client client){
        this.client = client;
        updateClient();
    }

    private void updateClient(){
        if (client == null) return;
        this.publicKey.setText(client.getPublicKey());
        this.privateKey.setText(client.getPrivateKey());
        this.knownHost.setItems(client.getKnownHosts());
    }
}
