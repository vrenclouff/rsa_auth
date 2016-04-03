package dao;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Created by lukas_cerny on 1. 4. 2016.
 */
public class Client {

    private long id;

    private String name;

    private boolean connecting;

    private String publicKey;

    private String privateKey;

    private ObservableList<KnownHost> knownHosts = FXCollections.observableArrayList();

    public Client (long id, String name){
        this.id = id;
        this.name = name;
        this.connecting = false;
        this.publicKey = "";
        this.privateKey = "";
    }

    public long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPublicKey() {
        return publicKey;
    }
    public String getPrivateKey() {
        return privateKey;
    }
    public boolean isConnecting() {
        return connecting;
    }
    public void setConnecting(boolean connecting) {
        this.connecting = connecting;
    }
    public ObservableList<KnownHost> getKnownHosts() {
        return knownHosts;
    }
    public void setKnownHosts(ObservableList<KnownHost> knownHosts) {
        this.knownHosts = knownHosts;
    }
    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}
