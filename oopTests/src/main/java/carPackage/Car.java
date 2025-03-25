package carPackage;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Car implements Serializable {
    private int id;
    private String model;
    private int yearCreate;
    private double price;
    private String registerNumber;
    private double mileage;
    private LocalDate dateLastTechnicalInspection;




    public Car(int id , String model  , int yearCreate , double price , String registerNumber, double mileage , LocalDate dateLastTechnicalInspection){
        this.id = id;
        this.model = model;
        this.yearCreate = yearCreate;
        this.price = price;
        this.registerNumber = registerNumber;
        this.mileage = mileage;
        this.dateLastTechnicalInspection = dateLastTechnicalInspection;
    }

    public LocalDate getDateLastTechnicalInspection() {
        return dateLastTechnicalInspection;
    }

    public void setDateLastTechnicalInspection(LocalDate dateLastTechnicalInspection) {
        this.dateLastTechnicalInspection = dateLastTechnicalInspection;
    }
    public int getYearTechnicalInspection(){
        return dateLastTechnicalInspection.getYear();
    }
    public int getMonthTechnicalInspection(){
        return dateLastTechnicalInspection.getMonthValue();
    }
    public int getDayTechnicalInspection(){
        return dateLastTechnicalInspection.getDayOfMonth();
    }

    public double getMileage() {
        return mileage;
    }

    public void setMileage(double mileage) {
        this.mileage = mileage;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYearCreate(int yearCreate) {
        this.yearCreate = yearCreate;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setRegisterNumber(String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public int getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public int getYearCreate() {
        return yearCreate;
    }

    public double getPrice() {
        return price;
    }

    public String getRegisterNumber() {
        return registerNumber;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String format = getDateLastTechnicalInspection().format(formatter);
        return ("----------------------------------------------------\n" +
                "Car - "+model +". has id - "+id+". register number - "+registerNumber+"\n" +
                "Сar cost - "+price + "$ .Year of manufacture - "+yearCreate)+
                "\nCar mileage: "+mileage+"\nTime last technical inspection:"+format+
                "\n----------------------------------------------------";
    }
}