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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControlCarsByYearAndPrice {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane backStage;

    @FXML
    private TextField inputPriceTextField;

    @FXML
    private TextField inputYearTextField;

    @FXML
    private Button searchButt;

    @FXML
    private Text title;

    @FXML
    void initialize() {
        assert backStage != null : "fx:id=\"backStage\" was not injected: check your FXML file 'carsByYearAndPriceMore.fxml'.";
        assert inputPriceTextField != null : "fx:id=\"inputPriceTextField\" was not injected: check your FXML file 'carsByYearAndPriceMore.fxml'.";
        assert inputYearTextField != null : "fx:id=\"inputYearTextField\" was not injected: check your FXML file 'carsByYearAndPriceMore.fxml'.";
        assert searchButt != null : "fx:id=\"searchButt\" was not injected: check your FXML file 'carsByYearAndPriceMore.fxml'.";
        assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'carsByYearAndPriceMore.fxml'.";

    }
    public void start(){
        int year = Integer.parseInt(inputYearTextField.getText().trim());
        double price = Double.parseDouble(inputPriceTextField.getText().trim());
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/carTableView.fxml"));
            Parent root = loader.load();
            ControlTableView tableView = loader.getController();
            tableView.loadCarsByCarByAGivenYearAndThePriceIsGreaterThan(year , price);

            Stage stage = new Stage();
            stage.setTitle("test");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}