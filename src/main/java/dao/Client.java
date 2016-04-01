package dao;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by lukas_cerny on 1. 4. 2016.
 */
public class Client {

    private long id;

    private StringProperty name;

    private StringProperty publicKey;

    private StringProperty privateKey;

    public Client (String name){
        this.name = new SimpleStringProperty(name);
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getPublicKey() {
        return publicKey.get();
    }

    public StringProperty publicKeyProperty() {
        return publicKey;
    }

    public String getPrivateKey() {
        return privateKey.get();
    }

    public StringProperty privateKeyProperty() {
        return privateKey;
    }
}
