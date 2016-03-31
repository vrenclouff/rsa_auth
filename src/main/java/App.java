package main.java;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.utils.LocateString;
import main.java.view.AboutController;
import main.java.view.FXMLTemplates;
import main.java.view.RootController;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(FXMLTemplates.INDEX);
//        RootController controller = new FXMLLoader().getController();
//        controller.setDialogStage(primaryStage);
        primaryStage.setTitle(LocateString.getValue("title.app"));
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
