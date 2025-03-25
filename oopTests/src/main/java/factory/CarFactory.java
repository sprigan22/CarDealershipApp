package factory;

import carPackage.Car;

import java.time.LocalDate;


public class CarFactory {
    public static Car createCar(int id , String model  , int yearCreate , double price , String registerNumber, double mileage , LocalDate date){
        return new Car(id, model , yearCreate , price , registerNumber , mileage , date);
    }

}
