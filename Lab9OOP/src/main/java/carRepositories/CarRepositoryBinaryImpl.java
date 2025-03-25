package carRepositories;

import carPackage.Car;
import interfaces.CarRepository;

import java.io.*;
import java.util.List;

public class CarRepositoryBinaryImpl implements CarRepository {
    @Override
    public void outputArray(List<Car> t, File file) {
        try(ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))){
            outputStream.writeObject(t);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void outputArray(List<Car> t, String fileName) {
        outputArray(t , new File(fileName));
    }

    @Override
    public List<Car> readArray(File file) {
        try(ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(file))){
            List<Car> cars = (List<Car>) inputStream.readObject();
            return cars;
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Car> readArray(String fileName) {
        return readArray(new File(fileName));
    }
}
