package app;

import dao.Client;
import dao.KnownHost;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.LocateString;
import view.FXMLTemplates;
import view.RootController;

import java.io.IOException;

/**
 * Created by lukas_cerny on 1. 4. 2016.
 */
public class AppController extends Application {

    private Client client1;

    private Client client2;

    private Client server;

    public AppController(){
        this.server = new Client(0, "Server");
        this.client1 = new Client(1, "Client 1");
        this.client2 = new Client(2, "Client 2");
    }

    @Override
    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader(FXMLTemplates.INDEX);
        Parent root = null;
        try {
            root = (Parent) loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        RootController controller = loader.getController();
        controller.setAppController(this);
        controller.setDialogStage(primaryStage);

        primaryStage.setTitle(LocateString.getValue("title.app"));
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.show();
    }

    public boolean authentication(Client client){
        KnownHost host = server.getKnownHosts().stream().filter(knownHost -> knownHost.getKey().contains(client.getName())).findFirst().orElse(null);
        return host != null ? true : false;
    }

    public void run(String [] args){
        launch(args);
    }

    public Client getClient1() {
        return client1;
    }
    public Client getClient2() {
        return client2;
    }
    public Client getServer() {
        return server;
    }

}
