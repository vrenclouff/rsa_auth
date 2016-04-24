package app;

import dao.Client;
import dao.KnownHost;
import dto.Key;
import dto.PrivateKey;
import dto.PublicKey;
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
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.List;
import java.util.stream.Collectors;

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
        if (client == null) return false;
        List<KnownHost> hosts = server.getKnownHosts().stream().filter(knownHost -> knownHost.getKey().contains(client.getName())).collect(Collectors.toList());
        if (hosts == null) return false;

        /** Vygenerovani velkeho nahodneho cisla */
        BigInteger randomNumber = BigInteger.probablePrime(256, new SecureRandom());

        for (KnownHost host : hosts) {
            /** Zasifrovano verejnym klicem */
            Key hostPublicKey = new PublicKey(host.getKey(), client.getName());
            BigInteger cipher = RSA.encrypt(hostPublicKey, randomNumber);

            /** Zasifrovane cislo desifrovano privatnim klicem */
            Key clientPrivateKey = new PrivateKey(client.getPrivateKey());
            BigInteger plane = RSA.decrypt(clientPrivateKey, cipher);

            /** Porovnani vysledku */
            if (plane.compareTo(randomNumber) == 0) return true;
        }
        return false;
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
