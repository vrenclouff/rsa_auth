package view;

import java.net.URL;

/**
 * Created by lukas_cerny on 30. 3. 2016.
 */
public class FXMLTemplates {

    /** Slozka se sablonami */
    private static final String FOLDER = "/templates/";

    /** Index sablona */
    public static final URL INDEX = FXMLTemplates.class.getResource(FOLDER+"root.fxml");

    /** O Aplikaci sablona */
    public static final URL ABOUT = FXMLTemplates.class.getResource(FOLDER+"about.fxml");

    /** Editace klienta sablona */
    public static final URL EDIT = FXMLTemplates.class.getResource(FOLDER+"editClient.fxml");

    /** PopUp pridani klice sablona */
    public static final URL ADD_KEY = FXMLTemplates.class.getResource(FOLDER+"addPublicKey.fxml");

    /** Sifrovaci mod sablona */
    public static final URL CIPHER_MODE = FXMLTemplates.class.getResource(FOLDER+"cipherMode.fxml");
}
