import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.LocateString;
import view.FXMLTemplates;

/**
 * Created by lukas_cerny on 1. 4. 2016.
 */
public class AppController extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(FXMLTemplates.INDEX);
        primaryStage.setTitle(LocateString.getValue("title.app"));
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.setOnCloseRequest(e -> Platform.exit());
        primaryStage.show();
    }

    public void run(String [] args){
        launch(args);
    }
}
