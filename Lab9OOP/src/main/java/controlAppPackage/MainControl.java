package controlAppPackage;

import java.net.URL;
import java.util.ResourceBundle;

import carRepositories.CarRepositoryBinaryImpl;
import carRepositories.CarRepositoryTextImpl;
import interfaces.CarRepository;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert.AlertType;
import servicePackage.ServiceClass;

public class MainControl {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button CarByYearAndPriceHighButt;
    public void setCarByYearAndPriceHighButt(){
        try{
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/carsByYearAndPriceMore.fxml"));
            Parent root = fxmlLoader.load();
            ControlCarsByYearAndPrice cars = fxmlLoader.getController();
            Stage stage = new Stage();
            stage.setTitle("Sort cars by year and price");
            stage.setScene(new Scene(root));
            stage.show();

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }

    @FXML
    private Button HighestPriceButt;
    public void CarsOnlyHighestPrice() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/carTableView.fxml"));
            Parent root = loader.load();
            ControlTableView controlTableView = loader.getController();
            controlTableView.setFunctionNumber(13);
            Stage stage = new Stage();
            stage.setTitle("test");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private Button SearchCarByModelButt;
    public void setSearchCarByModelButt() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EnterOneStringVariable.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle("Search by model");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    private Button addNewCarButt;
    public void setAddNewCarButt(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EnterCar.fxml"));
            Parent root = loader.load();
            ControlEnterCar car = loader.getController();
            car.setOptionId(1);

            Stage stage = new Stage();
            stage.setTitle("Add new car");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    private ImageView backgroundMainPNG;

    @FXML
    private AnchorPane base_pane;

    @FXML
    private ImageView dealPNG;

    @FXML
    private Button deleteCarButt;
    public void setDeleteCarButt(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EnterCar.fxml"));
            Parent root = loader.load();
            ControlEnterCar car = loader.getController();
            car.setOptionId(2);

            Stage stage = new Stage();
            stage.setTitle("Delete car");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private Button exitButt;
    public void setExitButt(){
        Platform.exit();
    }

    @FXML
    private ImageView firstCarPNG;

    @FXML
    private Button helpButt;
    public void setHelpButt(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Help");
        alert.setHeaderText(null);
        alert.setContentText("For help with this app, please contact the creator. Vladislav Pavliuk 2145 group.");
        alert.showAndWait();

    }

    @FXML
    private Button infoButt;
    public void setInfoButt(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("This application was created for 9 laboratory work with the subject of OOP with the participation of collections and lambdas");
        alert.showAndWait();

    }

    @FXML
    private Button listModelManufacButt;
    public void CarsModelManufac(){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/carTableView.fxml"));
                Parent root = loader.load();
                ControlTableView controlTableView = loader.getController();
                controlTableView.setFunctionNumber(12);
                Stage stage = new Stage();
                stage.setTitle("Cars sorting by model and manufacture");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
        }
    }

    @FXML
    private Button operationYearMoreButt;
    public void setOperationYearMoreButt(){
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/EnterOneVariableInteger.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Sort by operation more n years");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
    }

    @FXML
    private Button readCarsBinaryButt;
    public void setReadCarsBinaryButt() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/carTableView.fxml"));
            Parent root = loader.load();
            ControlTableView controlTableView = loader.getController();
            controlTableView.setFunctionNumber(7);
            Stage stage = new Stage();
            stage.setTitle("Read cars in on binary file");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private Button readCarsFileTxtButt;
    public void setReadCarsFileTxtButt(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/carTableView.fxml"));
            Parent root = loader.load();
            ControlTableView controlTableView = loader.getController();
            controlTableView.setFunctionNumber(5);
            Stage stage = new Stage();
            stage.setTitle("Read cars in on txt file");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private Button saveCarsFileBinaryButt;
    public void setSaveCarsFileBinaryButt(){
        CarRepository repository = new CarRepositoryBinaryImpl();
        repository.outputArray(ServiceClass.returnCars() , "cars.bin");
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("successful save");
        alert.showAndWait();
    }

    @FXML
    private Button saveFileButtTxtButt;
    public void setSaveFileButtTxtButt(){
        CarRepository repository = new CarRepositoryTextImpl();
        repository.outputArray(ServiceClass.returnCars() , "cars.txt");
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("successful save");
        alert.showAndWait();
    }

    @FXML
    private Button searchCarButt;
    public void setSearchCarButt(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/EnterCar.fxml"));
            Parent root = loader.load();
            ControlEnterCar car = loader.getController();
            car.setOptionId(3);

            Stage stage = new Stage();
            stage.setTitle("Search car");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    private Button sortTechnicalInspectButt;
    public void carsByTechInspect(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/carTableView.fxml"));
            Parent root = loader.load();
            ControlTableView controlTableView = loader.getController();
            controlTableView.setFunctionNumber(8);
            Stage stage = new Stage();
            stage.setTitle("Sort by technical inspect");
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    private AnchorPane twice_pane;

    @FXML
    void initialize() {
        assert CarByYearAndPriceHighButt != null : "fx:id=\"CarByYearAndPriceHighButt\" was not injected: check your FXML file 'start.fxml'.";
        assert HighestPriceButt != null : "fx:id=\"HighestPriceButt\" was not injected: check your FXML file 'start.fxml'.";
        assert SearchCarByModelButt != null : "fx:id=\"SearchCarByModelButt\" was not injected: check your FXML file 'start.fxml'.";
        assert addNewCarButt != null : "fx:id=\"addNewCarButt\" was not injected: check your FXML file 'start.fxml'.";
        assert backgroundMainPNG != null : "fx:id=\"backgrounfMainPNG\" was not injected: check your FXML file 'start.fxml'.";
        assert base_pane != null : "fx:id=\"base_pane\" was not injected: check your FXML file 'start.fxml'.";
        assert dealPNG != null : "fx:id=\"dealPNG\" was not injected: check your FXML file 'start.fxml'.";
        assert deleteCarButt != null : "fx:id=\"deleteCarButt\" was not injected: check your FXML file 'start.fxml'.";
        assert exitButt != null : "fx:id=\"exitButt\" was not injected: check your FXML file 'start.fxml'.";
        assert firstCarPNG != null : "fx:id=\"firstCarPNG\" was not injected: check your FXML file 'start.fxml'.";
        assert helpButt != null : "fx:id=\"helpButt\" was not injected: check your FXML file 'start.fxml'.";
        assert infoButt != null : "fx:id=\"infoButt\" was not injected: check your FXML file 'start.fxml'.";
        assert listModelManufacButt != null : "fx:id=\"listModelManufacButt\" was not injected: check your FXML file 'start.fxml'.";
        assert operationYearMoreButt != null : "fx:id=\"operationYearMoreButt\" was not injected: check your FXML file 'start.fxml'.";
        assert readCarsBinaryButt != null : "fx:id=\"readCarsBinaryButt\" was not injected: check your FXML file 'start.fxml'.";
        assert readCarsFileTxtButt != null : "fx:id=\"readCarsFileTxtButt\" was not injected: check your FXML file 'start.fxml'.";
        assert saveCarsFileBinaryButt != null : "fx:id=\"saveCarsFileBinaryButt\" was not injected: check your FXML file 'start.fxml'.";
        assert saveFileButtTxtButt != null : "fx:id=\"saveFileButtTxtButt\" was not injected: check your FXML file 'start.fxml'.";
        assert searchCarButt != null : "fx:id=\"searchCarButt\" was not injected: check your FXML file 'start.fxml'.";
        assert sortTechnicalInspectButt != null : "fx:id=\"sortTechnicalInspectButt\" was not injected: check your FXML file 'start.fxml'.";
        assert twice_pane != null : "fx:id=\"twice_pane\" was not injected: check your FXML file 'start.fxml'.";

    }

}
