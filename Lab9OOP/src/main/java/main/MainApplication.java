package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import servicePackage.ServiceClass;

public class MainApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        ServiceClass.initializeCars();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/start.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Dealership");
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }
}
