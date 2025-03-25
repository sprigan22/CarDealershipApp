package carRepositories;

import carPackage.Car;
import interfaces.CarRepository;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class CarRepositoryTextImpl implements CarRepository {
    @Override
    public void outputArray(List<Car> t, File file) {
        try(PrintWriter printWriter = new PrintWriter(file)){

            t.forEach(car -> printWriter.println(
                    car.getId()+","+car.getModel()+','+car.getYearCreate()+','+car.getPrice()+
                            ','+car.getRegisterNumber()+','+car.getMileage()+","+
                            car.getYearTechnicalInspection()+","+car.getMonthTechnicalInspection()+','+
                            car.getDayTechnicalInspection()
            ));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void outputArray(List<Car> t, String fileName) {
        outputArray(t , new File(fileName) );
    }

    @Override
    public List<Car> readArray(File file) {
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            List<Car> cars = new ArrayList<>();
            while (bufferedReader.ready()){
                String[] parts= bufferedReader.readLine().split(",");
                cars.add(new Car(Integer.parseInt(parts[0]) , parts[1] , Integer.parseInt(parts[2]),
                        Double.parseDouble(parts[3]) , parts[4] , Double.parseDouble(parts[5]) , LocalDate.of(Integer.parseInt(parts[6]) , Integer.parseInt(parts[7]) , Integer.parseInt(parts[8]))));
            }
            return cars;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public List<Car> readArray(String fileName) {
        return readArray(new File(fileName));
    }
}