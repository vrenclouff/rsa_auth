package dao;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Created by lukas_cerny on 3. 4. 2016.
 */
public class KnownHost {

    private StringProperty name;

    private StringProperty key;

    public KnownHost(String name, String key){
        this.name = new SimpleStringProperty(name);
        this.key = new SimpleStringProperty(key);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public String getKey() {
        return key.get();
    }

    public StringProperty keyProperty() {
        return key;
    }
}
