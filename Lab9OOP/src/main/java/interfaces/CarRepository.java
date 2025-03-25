package interfaces;

import carPackage.Car;

import java.io.File;
import java.util.List;


public interface CarRepository extends Repository<Car>{
    @Override
    default void outputArray(List<Car> t, File file) {

    }

    @Override
    default void outputArray(List<Car> t, String fileName) {

    }

    @Override
    default List<Car> readArray(File file) {
        return null;
    }

    @Override
    default List<Car> readArray(String fileName) {
        return null;
    }

}
