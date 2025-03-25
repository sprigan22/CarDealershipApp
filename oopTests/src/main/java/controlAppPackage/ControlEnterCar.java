package controlAppPackage;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import carPackage.Car;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import servicePackage.ServiceClass;

public class ControlEnterCar {
    private int optionId;
    public void setOptionId(int optionId){
        this.optionId  = optionId;
    }

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField InputDateLastInspectionTextField;

    @FXML
    private AnchorPane backStage;

    @FXML
    private TextField inputIdTextField;

    @FXML
    private TextField inputMileageTextField;

    @FXML
    private TextField inputModelTextField;

    @FXML
    private TextField inputPriceTextField;

    @FXML
    private TextField inputRegisterNameTextField;

    @FXML
    private TextField inputYearTextField;

    @FXML
    private Button saveButton;
    public void setSaveButton(){
        int id = Integer.parseInt(inputIdTextField.getText().trim());
        String model= inputModelTextField.getText().trim();
        int year = Integer.parseInt(inputYearTextField.getText().trim());
        double price = Double.parseDouble(inputPriceTextField.getText().trim());
        String registerName = inputRegisterNameTextField.getText().trim();
        double mileage = Double.parseDouble(inputMileageTextField.getText().trim());
        String[] date = InputDateLastInspectionTextField.getText().split("/");
        LocalDate localDate = LocalDate.of(Integer.parseInt(date[2]) , Integer.parseInt(date[1]) , Integer.parseInt(date[0]));
        Car car = new Car(id , model , year , price , registerName , mileage , localDate);
        options(optionId , car);
    }
    private void addNewCar(Car car){
        ServiceClass serviceClass = new ServiceClass();
        serviceClass.addNewCar(car.getId() , car.getModel() , car.getYearCreate() , car.getPrice() , car.getRegisterNumber(),
                car.getMileage() , car.getDateLastTechnicalInspection());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information");
        alert.setHeaderText(null);
        alert.setContentText("successful save");
        alert.showAndWait();
    }
    private void deleteCar(Car car){
        ServiceClass serviceClass = new ServiceClass();
        boolean isDelete = serviceClass.deleteCar(car.getId() , car.getModel() , car.getYearCreate() , car.getPrice() , car.getRegisterNumber(),
                car.getMileage() , car.getDateLastTechnicalInspection());
        if(isDelete) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Information");
            alert.setHeaderText(null);
            alert.setContentText("successful delete");
            alert.showAndWait();
        }
        if(!isDelete) {
            Alert alert2 = new Alert(Alert.AlertType.ERROR);
            alert2.setTitle("Error");
            alert2.setHeaderText(null);
            alert2.setContentText("error delete");
            alert2.showAndWait();
        }

    }
    private void searchCar(Car car){
        ServiceClass serviceClass = new ServiceClass();
        List<Car> cars= serviceClass.searchCar(car.getId() , car.getModel() , car.getYearCreate() , car.getPrice() , car.getRegisterNumber(),
                car.getMileage() , car.getDateLastTechnicalInspection());
        if(!cars.isEmpty()) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/carTableView.fxml"));
                Parent root = loader.load();
                ControlTableView controlTableView = loader.getController();
                controlTableView.loadCarsByList(cars);
                Stage stage = new Stage();
                stage.setTitle("test");
                stage.setScene(new Scene(root));
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(cars.isEmpty()) {
            Alert alert2 = new Alert(Alert.AlertType.WARNING);
            alert2.setTitle("Warning");
            alert2.setHeaderText(null);
            alert2.setContentText("Car is not found");
            alert2.showAndWait();
        }
    }
    private void options(int optionId , Car car){
        switch (optionId){
            case 1:
                addNewCar(car);
                break;
            case 2:
                deleteCar(car);
                break;
            case 3:
                searchCar(car);
                break;
            default:
                break;
        }
    }

    @FXML
    private Text title;

    @FXML
    void initialize() {
        assert InputDateLastInspectionTextField != null : "fx:id=\"InputDateLastInspectionTextField\" was not injected: check your FXML file 'EnterCar.fxml'.";
        assert backStage != null : "fx:id=\"backStage\" was not injected: check your FXML file 'EnterCar.fxml'.";
        assert inputIdTextField != null : "fx:id=\"inputIdTextField\" was not injected: check your FXML file 'EnterCar.fxml'.";
        assert inputMileageTextField != null : "fx:id=\"inputMileageTextField\" was not injected: check your FXML file 'EnterCar.fxml'.";
        assert inputModelTextField != null : "fx:id=\"inputModelTextField\" was not injected: check your FXML file 'EnterCar.fxml'.";
        assert inputPriceTextField != null : "fx:id=\"inputPriceTextField\" was not injected: check your FXML file 'EnterCar.fxml'.";
        assert inputRegisterNameTextField != null : "fx:id=\"inputRegisterNameTextField\" was not injected: check your FXML file 'EnterCar.fxml'.";
        assert inputYearTextField != null : "fx:id=\"inputYearTextField\" was not injected: check your FXML file 'EnterCar.fxml'.";
        assert saveButton != null : "fx:id=\"saveButton\" was not injected: check your FXML file 'EnterCar.fxml'.";
        assert title != null : "fx:id=\"title\" was not injected: check your FXML file 'EnterCar.fxml'.";

    }

}