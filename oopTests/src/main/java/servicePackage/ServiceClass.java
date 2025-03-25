package servicePackage;

import carPackage.Car;
import factory.CarFactory;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class ServiceClass {
    private static List<Car> cars = new ArrayList<>();

    public List<Car> searchByYearsOfUseMore(int year){
        return  cars.stream().filter(car -> 2025-car.getYearCreate()>year).collect(Collectors.toList());
    }


    public List<Car> searchByYearCreateAndPriceMore(int year , double price){
        return cars.stream().filter(car -> (car.getYearCreate()==year && car.getPrice()>price)).collect(Collectors.toList());
    }

    public static void initializeCars(){
        if(cars.isEmpty()) {
            cars.add(CarFactory.createCar(1, "Porsche", 2023, 45000, "AA 2222 GG", 100.5, LocalDate.of(2025, 10, 3)));
            cars.add(CarFactory.createCar(2, "BMW", 2007, 13450, "BC 9147 OP", 99.6, LocalDate.of(2024, 5, 10)));
            cars.add(CarFactory.createCar(3, "Mazda", 2025, 65000, "AN 7777 KT", 1400.4, LocalDate.of(2024, 12, 8)));
            cars.add(CarFactory.createCar(4, "Ford", 2014, 11420, "AC 8888 KT", 653.9, LocalDate.of(2025, 1, 22)));
            cars.add(CarFactory.createCar(5, "Range Rover", 2019, 34600, "AA 3281 KT", 555.5, LocalDate.of(2024, 4, 28)));
            cars.add(CarFactory.createCar(6, "Porsche", 2023, 12040, "BE 8132 KF", 167.9, LocalDate.of(2023, 9, 19)));
            cars.add(CarFactory.createCar(7, "BMW", 2011, 87000, "CB 4797 PO", 198.6, LocalDate.of(2024, 1, 22)));
            cars.add(CarFactory.createCar(8, "Mazda", 2009, 100003, "CC 8132 TK", 2400.1, LocalDate.of(2025, 2, 28)));
            cars.add(CarFactory.createCar(9, "Mazda", 2006, 87300, "CV 8199 NT", 959.9, LocalDate.of(2024, 11, 19)));
            cars.add(CarFactory.createCar(10, "Ford", 2022, 9999, "VV 2817 MM", 456.7, LocalDate.of(2023, 2, 2)));
            cars.add(CarFactory.createCar(11, "Ford", 2020, 4560, "BG 2831 NE", 567.8, LocalDate.of(2024, 8, 17)));
            cars.add(CarFactory.createCar(12, "BMW", 2013, 43000, "CC 9999 CC", 9101.9, LocalDate.of(2023, 5, 9)));
            cars.add(CarFactory.createCar(13, "Porsche", 2012, 65000, "ME 2018 MP", 110.0, LocalDate.of(2024, 4, 26)));
            cars.add(CarFactory.createCar(14, "Porsche", 2015, 91200, "CE 5312 TT", 777.6, LocalDate.of(2024, 12, 29)));
        }
    }
    public static List<Car> returnCars(){
        return cars;
    }
    public boolean deleteCar(int id , String model , int yearCreate , double price, String registerName,
                             double mileage , LocalDate lastTechnicalInspection){
        boolean b = cars.removeIf(car -> car.getId()==id && car.getModel().equalsIgnoreCase(model) && car.getYearCreate()==yearCreate &&
                car.getPrice()==price && car.getRegisterNumber().equalsIgnoreCase(registerName.trim()) && car.getMileage()==mileage && car.getDateLastTechnicalInspection().equals(lastTechnicalInspection));
        if(b){
            System.out.println("Car is delete!");
        } else {
            System.out.println("Car not found!");
        }
        return b;
    }
    public  void addNewCar(int id , String model , int year , double price , String regNumber , double mileage , LocalDate date){
        boolean cont = cars.stream().anyMatch(car -> car.getId()==id);
        if(!cont) {
            cars.add(CarFactory.createCar(id, model, year, price, regNumber, mileage, date));
        }
    }

    public List<Car> searchByModel(String s) {
        return cars.stream().filter(car -> car.getModel().equalsIgnoreCase(s)).collect(Collectors.toList());
    }
    public List<Car> sortByTechnicalInspect(List<Car> cars){
        return cars.stream()
                .sorted(Comparator.comparing(Car::getDateLastTechnicalInspection))
                .collect(Collectors.toList());

    }
    public List<Car> searchCar(int id , String model  , int yearCreate , double price , String registerNumber, double mileage , LocalDate dateLastTechnicalInspection){
        return cars.stream()
                .filter(car -> car.getId() == id
                        && car.getYearCreate() == yearCreate
                        && Double.compare(car.getPrice(), price) == 0
                        && car.getRegisterNumber().trim().equalsIgnoreCase(registerNumber.trim())
                        && Double.compare(car.getMileage(), mileage) == 0
                        && car.getDateLastTechnicalInspection().equals(dateLastTechnicalInspection))
                .collect(Collectors.toList());
    }
}
