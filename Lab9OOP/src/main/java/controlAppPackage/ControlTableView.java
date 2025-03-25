package controlAppPackage;

import java.io.File;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

import carPackage.Car;
import carPackage.CarMap;
import carRepositories.CarRepositoryBinaryImpl;
import carRepositories.CarRepositoryTextImpl;
import interfaces.CarRepository;
import interfaces.Repository;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import servicePackage.ServiceClass;

public class ControlTableView {
    private int functionNumber;
    private String model;



    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Car, Integer> CarId;

    @FXML
    private TableView<Car> CarTableView;

    @FXML
    private AnchorPane background2;

    @FXML
    private TableColumn<Car, LocalDate> carLastTechnicalInspection;

    @FXML
    private TableColumn<Car, Double> carMilleage;

    @FXML
    private TableColumn<Car, String> carModel;

    @FXML
    private TableColumn<Car, Double> carPrice;

    @FXML
    private TableColumn<Car, String> carRegisterName;

    @FXML
    private TableColumn<Car, Integer> carYearCreate;

    @FXML
    private ImageView salesPNG;

    @FXML
    public void initialize() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        CarId.setCellValueFactory(new PropertyValueFactory<>("id"));
        carMilleage.setCellValueFactory(new PropertyValueFactory<>("mileage"));
        carModel.setCellValueFactory(new PropertyValueFactory<>("model"));
        carPrice.setCellValueFactory(new PropertyValueFactory<>("price"));
        carYearCreate.setCellValueFactory(new PropertyValueFactory<>("yearCreate"));
        carRegisterName.setCellValueFactory(new PropertyValueFactory<>("registerNumber"));
        carLastTechnicalInspection.setCellValueFactory(new PropertyValueFactory<>("dateLastTechnicalInspection"));

        carLastTechnicalInspection.setCellFactory(column -> new TextFieldTableCell<>(
                new javafx.util.StringConverter<>(){
                    @Override
                    public String toString(LocalDate object) {
                        return object.format(formatter);
                    }

                    @Override
                    public LocalDate fromString(String string) {
                        return (LocalDate.parse(string , formatter));
                    }
                }
        ));

    }

    private void executeFunction(){
        switch (functionNumber){
            case 5:
                loadCarsByReadTxt();
                break;
            case 7:
                loadCarsByReadBinary();
                break;
            case 8:
                loadCarsBySortByTechnicalInspect();
                break;
            case 9:
                loadCarsBySearchCar();
                break;
            case 12:
                loadCarsByCarsOfThisModelAndDescendingYearOfManufacture();
                break;
            case 13:
                loadCarsByHighestPrice();
                break;
            default:
                break;
        }
    }
    private void loadCarsByHighestPrice(){
        CarMap carMap = new CarMap();
        List<Car> cars = carMap.carByModelIsHighestPrice();
        CarTableView.setItems(FXCollections.observableArrayList(cars));
    }
    public void loadCarsBySearchCarByModel(String model){
        ServiceClass serviceClass = new ServiceClass();
        CarTableView.setItems(FXCollections.observableArrayList(serviceClass.searchByModel(model)));
    }
    public void loadCarsByList(List<Car> cars){
        CarTableView.setItems(FXCollections.observableArrayList(cars));
    }
    public void loadCarsByCarInOperationForMoreThanNYears(int year){
        ServiceClass serviceClass = new ServiceClass();
        CarTableView.setItems(FXCollections.observableArrayList(serviceClass.searchByYearsOfUseMore(year)));

    }
    public void loadCarsByCarByAGivenYearAndThePriceIsGreaterThan(int year , double price){
        ServiceClass serviceClass = new ServiceClass();
        CarTableView.setItems(FXCollections.observableArrayList(serviceClass.searchByYearCreateAndPriceMore(year , price)));
    }
    private void loadCarsBySortByTechnicalInspect(){
        ServiceClass serviceClass = new ServiceClass();
        List<Car> cars = ServiceClass.returnCars();
        cars = serviceClass.sortByTechnicalInspect(cars);
        CarTableView.setItems(FXCollections.observableArrayList(cars));

    }
    private void loadCarsBySearchCar(){

    }
    private void loadCarsByCarsOfThisModelAndDescendingYearOfManufacture(){
       CarMap carMap = new CarMap();
       List<Car> cars = carMap.carByModelAndYearCreating();
       CarTableView.setItems(FXCollections.observableArrayList(cars));

    }

    public void setFunctionNumber(int i) {
        this.functionNumber = i;
        executeFunction();
    }
    private void loadCarsByReadTxt(){
        CarRepository repository = new CarRepositoryTextImpl();
        File txtFile = new File("cars.txt");
        List<Car> cars =  repository.readArray(txtFile);
        CarTableView.setItems(FXCollections.observableArrayList(cars));

    }
    private void loadCarsByReadBinary(){
        CarRepository repository = new CarRepositoryBinaryImpl();
         File binFile = new File("cars.bin");
        List<Car> cars =  repository.readArray(binFile);
        CarTableView.setItems(FXCollections.observableArrayList(cars));
    }

}
