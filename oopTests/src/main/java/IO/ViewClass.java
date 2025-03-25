package IO;


import carPackage.Car;

import java.util.List;

public class ViewClass {
    public static void showCars(List<Car> cars){
        cars.forEach(System.out::println);
    }
}
