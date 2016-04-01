package view;

import java.net.URL;

/**
 * Created by lukas_cerny on 30. 3. 2016.
 */
public class FXMLTemplates {

    private static final String FOLDER = "/templates/";

    public static final URL INDEX = FXMLTemplates.class.getResource(FOLDER+"root.fxml");
    public static final URL ABOUT = FXMLTemplates.class.getResource(FOLDER+"about.fxml");
    public static final URL EDIT = FXMLTemplates.class.getResource(FOLDER+"editClient.fxml");
    public static final URL ADD_KEY = FXMLTemplates.class.getResource(FOLDER+"addPublicKey.fxml");

}
