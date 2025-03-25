package interfaces;

import carPackage.Car;

import java.io.File;
import java.util.List;


public interface Repository<T> {
    void outputArray(List<Car> t, File file);
    void outputArray(List<Car> t, String fileName);
    List<Car> readArray(File file);
    List<Car> readArray(String fileName);
}
