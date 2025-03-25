package carPackage;

import IO.ViewClass;
import servicePackage.ServiceClass;

import java.util.*;

public class CarMap {
    private static Map<String , ArrayList<Car>> cars = new HashMap<>();

    public void updateMap(){
        cars = new HashMap<>();
        ServiceClass.initializeCars();
        List<Car> carList = ServiceClass.returnCars();
        carList.forEach(car ->
                cars.computeIfAbsent(car.getModel(), k -> new ArrayList<>()).add(car)
        );
    }

    public List<Car> carByModelIsHighestPrice(){
        updateMap();
        List<Car> cars1 = new ArrayList<>();
        cars.forEach((model, carList) -> {
            if (carList.size() > 1) {
                carList.sort(Comparator.comparingDouble(Car::getPrice).reversed());
            }
            cars1.add(carList.get(0));
        });
        return cars1;

    }

    public List<Car> carByModelAndYearCreating(){
        updateMap();
        List<Car> cars1 = new ArrayList<>();
        cars.forEach((model , carList) ->{
            if(carList.size()>1){
                carList.sort(Comparator.comparingInt(Car::getYearCreate).reversed());
            }
            cars1.addAll(carList);
        });
        return cars1;
    }
}
