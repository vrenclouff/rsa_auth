package view;

import app.AppController;
import dao.Client;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
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
    private MenuItem reset;

    @FXML
    private ImageView client1_status;

    @FXML
    private ImageView client2_status;

    @FXML
    private ImageView server_status1;

    @FXML
    private ImageView server_status2;

    @FXML
    private Button client1_edit;

    @FXML
    private Button client1_connect;

    @FXML
    private Button client2_edit;

    @FXML
    private Button client2_connect;

    @FXML
    private Button server_edit;

    private AppController appController;
    private Stage primaryStage;


    @FXML
    private void initialize() {

        client1_connect.setText(LocateString.getValue("button.connect"));
        changeStatus(client1_status, false);
        changeStatus(server_status1, false);

        client2_connect.setText(LocateString.getValue("button.connect"));
        changeStatus(client2_status, false);
        changeStatus(server_status2, false);

        reset.setOnAction((event) -> reset());
        client1_edit.setOnAction((event) -> showEdit(appController.getClient1()));
        client2_edit.setOnAction((event) -> showEdit(appController.getClient2()));
        server_edit.setOnAction((event) -> showEdit(appController.getServer()));
        client1_connect.setOnAction((event -> updateStatus(appController.getClient1())));
        client2_connect.setOnAction((event -> updateStatus(appController.getClient2())));
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
    private void close(){
        Platform.exit();
    }


    private void reset(){
        updateStatus(appController.getClient1(), false);
        updateStatus(appController.getClient2(), false);
        appController.getClient1().getKnownHosts().clear();
        appController.getClient2().getKnownHosts().clear();
        appController.getServer().getKnownHosts().clear();
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

    private void updateStatus(Client client){
        boolean resultOfConnect;

        if (client.isConnecting()){
            resultOfConnect = false;
        }else {
            resultOfConnect = appController.authentication(client);
        }

        updateStatus(client, resultOfConnect);
    }

    private void updateStatus(Client client, boolean connecting){
        client.setConnecting(connecting);
        String status = connecting ? LocateString.getValue("button.disconnect") : LocateString.getValue("button.connect");
        if (client.getId() == 1){
            client1_connect.setText(status);
            changeStatus(client1_status, connecting);
            changeStatus(server_status1, connecting);
        } else if (client.getId() == 2){
            client2_connect.setText(status);
            changeStatus(client2_status, connecting);
            changeStatus(server_status2, connecting);
        }
    }

    private void showEdit(Client client){
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLTemplates.EDIT);
        AnchorPane page = null;
        try {
            page = (AnchorPane) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Stage dialogStage = new Stage();
        dialogStage.setTitle(LocateString.getValue("title.edit") + " " + client.getName());
        dialogStage.initModality(Modality.WINDOW_MODAL);
        dialogStage.initOwner(primaryStage);
        dialogStage.setScene(new Scene(page));

        EditClientController controller = loader.getController();

        controller.setClient(client);
        controller.setDialogStage(dialogStage);
        dialogStage.showAndWait();
    }

    private void changeStatus(ImageView client, boolean status){
        String image = "/images/";
        image += status ? "green.png" : "red.png";
        client.setImage(new Image(image));
    }

    public void setAppController(AppController appController) {
        this.appController = appController;
    }
}
