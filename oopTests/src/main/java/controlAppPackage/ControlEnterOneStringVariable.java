package controlAppPackage;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControlEnterOneStringVariable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField CarModelTextField;

    @FXML
    private AnchorPane backStage;

    @FXML
    private AnchorPane backStage2;

    @FXML
    private Button startSearchingButt;

    @FXML
    void initialize() {
        assert CarModelTextField != null : "fx:id=\"CarModelTextField\" was not injected: check your FXML file 'EnterOneStringVariable.fxml'.";
        assert backStage != null : "fx:id=\"backStage\" was not injected: check your FXML file 'EnterOneStringVariable.fxml'.";
        assert backStage2 != null : "fx:id=\"backStage2\" was not injected: check your FXML file 'EnterOneStringVariable.fxml'.";
        assert startSearchingButt != null : "fx:id=\"startSearchingButt\" was not injected: check your FXML file 'EnterOneStringVariable.fxml'.";

    }
    public void setText(){
        String textField = CarModelTextField.getText().trim();
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/carTableView.fxml"));
            Parent root = loader.load();
            ControlTableView tableView = loader.getController();
            tableView.loadCarsBySearchCarByModel(textField);

            Stage stage = new Stage();
            stage.setTitle("Search by model");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
