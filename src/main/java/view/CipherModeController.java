package view;

import app.AppController;
import app.KeyMachine;
import app.RSA;
import dto.Key;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.math.BigInteger;

/**
 * Created by lukas_cerny on 27. 4. 2016.
 */
public class CipherModeController {

    @FXML
    private ImageView encryptImg;

    @FXML
    private ImageView decryptImg;

    @FXML
    private TextArea planeTextInput;

    @FXML
    private TextArea planeTextOutput;

    @FXML
    private TextArea cipherText;

    private AppController appController;
    private Stage dialogStage;
    private Key privateKey;
    private Key publicKey;

    /**
     * Inicializace komponenty
     */
    @FXML
    private void initialize() {

        encryptImg.addEventFilter(MouseEvent.MOUSE_CLICKED, (event -> encryptHandler()));
        decryptImg.addEventFilter(MouseEvent.MOUSE_CLICKED, (event -> decryptHandler()));
    }

    /**
     * Nastaveni dialogoveho okna
     *
     * @param dialogStage
     */
    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    /**
     * Ukoncni okna O aplikaci
     */
    @FXML
    private void handleClose() {
        dialogStage.close();
    }

    private void encryptHandler() {
        String input = planeTextInput.getText();
        if (input.isEmpty()) return;
        KeyMachine machine = new KeyMachine(input.length()*4);
        privateKey = machine.privateKey();
        publicKey = machine.publicKey();

        BigInteger cipher = RSA.encrypt(publicKey, new BigInteger(input.getBytes()));
        cipherText.setText(cipher.toString());
    }

    private void decryptHandler() {
        String input = cipherText.getText();
        if (input.isEmpty()) return;
        BigInteger msg = RSA.decrypt(privateKey, new BigInteger(input));
        planeTextOutput.setText(new String(msg.toByteArray()));
    }

    public void setAppController(AppController appController){
        this.appController = appController;
    }
}
