package controlPackage;

import carPackage.Car;
import carPackage.CarMap;
import interfaces.CarRepository;
import javafx.event.ActionEvent;
import servicePackage.ServiceClass;
import carRepositories.CarRepositoryBinaryImpl;
import carRepositories.CarRepositoryTextImpl;
import IO.ViewClass;
import java.io.File;
import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class ControlClass {
    private static final Scanner scanner = new Scanner(System.in);
    private static final CarRepository repository = new CarRepositoryTextImpl();
    private static final CarRepository binaryRepository = new CarRepositoryBinaryImpl();
    private static final File txtFile = new File("cars.txt");
    private static final File binFile = new File("cars.bin");

    private int inputInteger(String text) {
        System.out.println(text);
        while (!scanner.hasNextInt()) {
            System.out.println("Error! Please repeat and input Integer type.");
            scanner.next();
            System.out.println(text);
        }
        int id = scanner.nextInt();
        scanner.nextLine();
        return id;
    }

    private String inputModel() {
        System.out.println("Input model: ");
        String model = scanner.nextLine().trim();
        return model;
    }

    private int inputYear() {
        System.out.println("Input year: ");
        while (!scanner.hasNextInt()) {
            errorMessage("Integer", "year");
            scanner.next();
            System.out.println("Input year: ");
        }
        int year = scanner.nextInt();
        scanner.nextLine();
        return year;
    }

    private double inputDouble(String text) {
        System.out.println(text);
        while (!scanner.hasNextDouble()) {
            errorMessage("Double", text);
            scanner.next();
            System.out.println(text);
        }
        double price = scanner.nextDouble();
        scanner.nextLine();
        return price;
    }

    public void startMethod() {
        ServiceClass.initializeCars();
        while (true) {
            menu();
            System.out.println("Select option: ");
            while (!scanner.hasNextInt()) {
                errorMessage("Integer", "choice option");
                scanner.next();
                System.out.println("Select option: ");
            }
            int choice = scanner.nextInt();
            scanner.nextLine();
            options(choice);
            if (choice == 14) {
                break;
            }
        }
    }

    private void options(int userChoice) {
        ServiceClass service = new ServiceClass();
        CarMap carMap = new CarMap();
        switch (userChoice) {
            case 1:
                ViewClass.showCars(service.searchByModel(inputModel()));
                break;
            case 2:
                ViewClass.showCars(service.searchByYearsOfUseMore(inputYear()));
                break;
            case 3:
                ViewClass.showCars( service.searchByYearCreateAndPriceMore(inputYear(), inputDouble("Input double type:")));
                break;
            case 4:
                repository.outputArray(ServiceClass.returnCars() ,txtFile);
                break;
            case 5:
                List<Car> cars =  repository.readArray(txtFile);
                ViewClass.showCars(cars);
                break;
            case 6:
                binaryRepository.outputArray(ServiceClass.returnCars() , binFile);
                break;
            case 7:
                List<Car> cars1  = binaryRepository.readArray(binFile);
                ViewClass.showCars(cars1);
                break;
            case 8:
                List<Car> cars2  = service.sortByTechnicalInspect(ServiceClass.returnCars());
                ViewClass.showCars(cars2);
                break;
            case 9:
                List<Car> cars3  = service.searchCar(inputInteger("Input id") , inputModel() , inputYear() , inputDouble("Input price") , inputRegisterName() ,inputMileage() , inputDateLastTechnicalInspection());
                ViewClass.showCars(cars3);
                break;
            case 10:
                service.addNewCar(inputInteger("Input id") , inputModel() , inputYear() , inputDouble("Input price") , inputRegisterName() ,inputMileage() , inputDateLastTechnicalInspection());
                break;
            case 11:
                service.deleteCar(inputInteger("Input id") , inputModel() , inputYear() , inputDouble("Input price") , inputRegisterName() ,inputMileage() , inputDateLastTechnicalInspection());
                break;
            case 12:
                carMap.carByModelAndYearCreating();
                break;
            case 13:
                carMap.carByModelIsHighestPrice();
                break;
            case 14:
                System.out.println("Bye!");
                break;
            default:
                System.out.println("Unknown option");
        }
    }

    private String inputRegisterName() {
        System.out.println("Input register name: ");
        String regName = scanner.nextLine().trim();
        return regName;
    }
    private double inputMileage() {
        double milleage = inputDouble("input mileage:");
        return milleage;
    }
    private LocalDate inputDateLastTechnicalInspection() {
        int year = inputInteger("Input year last inspection:");
        int month =  inputInteger("Input Month:");
        int day =  inputInteger("Input Day:");
        LocalDate time= LocalDate.of(year , month , day);
        return time;
    }

    private void menu() {
        System.out.println("1. Search car by model");
        System.out.println("2. Search for a car in operation for more than n years");
        System.out.println("3. Search for a car by a given year and the price is greater than the specified one");
        System.out.println("4. Save cars in file(text)");
        System.out.println("5. Read cars in file(text)");
        System.out.println("6. Save cars in file(binary)");
        System.out.println("7. Read cars in file(binary)");
        System.out.println("8. Sort by technical inspect");
        System.out.println("9. Search car");
        System.out.println("10. Add new car");
        System.out.println("11. Delete car");
        System.out.println("12. List of all cars of this model and descending year of manufacture");
        System.out.println("13. List model, the car of the highest price");
        System.out.println("14. Exit");
    }

    private void errorMessage(String type, String nameVariable) {
        System.out.println("Error! Please repeat and input " + type + " type.");
        System.out.println("Input " + nameVariable + ": ");
    }

}
