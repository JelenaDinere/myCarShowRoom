import cars.Car;
import cars.Showroom;


import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Main {
    Showroom showroom = new Showroom();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Main main = new Main();
        main.showMenu();
        main.findMenu();
    }

    void showMenu() {

        String userInput = "";
        do {
            System.out.println("Welcome to the showroom, please choose activity: ");
            System.out.println("1. Add Car");
            System.out.println("2. View All Cars");
            System.out.println("3.View Single Car");
            System.out.println("4. Remove Car");
            System.out.println("5. Remove car by Name");
            System.out.println("6. Update car by name");
            System.out.println("7. Update car by type");
            System.out.println("8. Find menu");
            System.out.println("\nEnter Quit to end program...");

            System.out.println("Choose a number:");
            userInput = scanner.nextLine();

            switch (userInput) {
                case "Quit":
                case "QUIT":
                    System.out.println("Exiting Application...");
                    break;
                //addCar
                case "1":
                    addCar();
                    break;
                //view all cars
                case "2":
                    viewAllCars();
                    break;
                //view single car
                case "3":
                    viewSingleCar();
                    break;
                case "4":
                    removeCar();
                    break;
                case "5":
                    removeCarByName();
                    break;
                case "6":
                    updateCar();
                    break;
                case "7":
                    updateCarByType();
                case "8":
                    findMenu();
                default:
                    break;
            }
        } while (!userInput.equalsIgnoreCase("Quit"));
        return;
    }

    void addCar() {

        System.out.println("Add Car");
        Car car = new Car();

        System.out.println("Enter Name:");
        car.name = scanner.nextLine();

        System.out.println("Enter Manufacturer");
        car.manufacturer = scanner.nextLine();

        System.out.println("Enter Type:");
        car.type = scanner.nextLine();

        car.id = UUID.randomUUID();
        String message = showroom.addCar(car);
        System.out.println(message);

    }

    void viewAllCars() {
        ArrayList<Car> allCars = showroom.getAllCars();
        System.out.println("All Available Cars");
        System.out.println("CarName \t Manufacturer \t CarType");
        for (Car car : allCars) {
            System.out.println(car.name + '\t' + car.manufacturer + '\t' + car.type);
        }
    }

    void viewSingleCar() {
        System.out.println("View single");
        System.out.println("Please provide car Index");

        int carIndex = scanner.nextInt();
        String message = showroom.getSingleCar(carIndex);
        System.out.println(message);
//         Car car = showroom.getSingleCar(carIndex);
//        System.out.println("Car Number"+ car.id);
//        System.out.println("Car Name"+ car.name);
//        System.out.println("Car Type"+ car.type);

    }

    void removeCar() {

        System.out.println("Enter car ID to remove");
        int carIndex = scanner.nextInt();
        String car = showroom.removeCar(carIndex);
        System.out.println(car);
    }







    void removeCarByName() {
        System.out.println("Remove Car By Name..");
        System.out.println("Enter  Car Name:");
        String carName = scanner.nextLine();
        Car car = showroom.findByName(carName);

        int carIndex = showroom.getAllCars().indexOf(car);
        System.out.println(showroom.removeCar(carIndex));
    }

    void updateCar() {
        System.out.println("Update Car...");
        System.out.println("Enter Car name:");
        String carName = scanner.nextLine();

        Car car = showroom.findByName(carName);
        int carIndex = showroom.getAllCars().indexOf(car);
        System.out.println("Enter the property you would like to change:");
        String property = scanner.nextLine();

        System.out.println("Enter the new value of:" + property);
        String value = scanner.nextLine();

        switch (property) {
            case "name":
                car.name = value;
                break;
            case "manufacturer":
                car.manufacturer = value;
                break;
            case "type":
                car.type = value;
                break;
            default:
                System.out.println("Please provide a valid property");
                break;
        }
        showroom.updateCar(carIndex, car);
        System.out.println(car.name + "\nUpdated successfully");
        System.out.println(car.manufacturer + "\nUpdated successfully");
        System.out.println(car.type + "\nUpdated successfully");
    }



    void updateCarByType() {
        System.out.println("Update Car...");
        System.out.println("Enter Car type:");
        String carType = scanner.nextLine();

        Car car = showroom.findByType(carType);
        int carIndex = showroom.getAllCars().indexOf(car);


        System.out.println("Enter the new value of type");
        car.type = scanner.nextLine();

        showroom.updateCar(carIndex, car);
        System.out.println(car.type + "\nupdated successfully");
    }

    void findMenu() {
        String userInput = "";
        do {
            System.out.println("Welcome to search menu: ");
            System.out.println("1. Find car by name");
            System.out.println("2. Find car by type");
            System.out.println("3. Find car by manufacturer");
            System.out.println("4. Update car by manufacturer");
            System.out.println("Choose an activity: ");
            userInput = scanner.nextLine();

            switch (userInput) {
                case "1":
                    findCarByName();
                    break;
                case "2":
                    findCarByType();
                    break;
                case "3":
                    findCarByManufacturer();
                    break;
                case "4":
                    updateCarByManufacturer();
                    break;
                default:
            }
        } while (!userInput.equalsIgnoreCase("Quit"));
        return;
    }
    void findCarByName() {

        System.out.println("Enter car name: ");
        String carName = scanner.nextLine();
        Car car = showroom.findByName(carName);

        System.out.println("car ID: " + car.id);
        System.out.println("car name: " + car.name);
        System.out.println("car manufacturer: " + car.manufacturer);
        System.out.println("car type: " + car.type);
    }
    void findCarByType() {
        System.out.println("Enter car type: ");
        String carType = scanner.next();
        Car car = showroom.findByType(carType);

        System.out.println("car ID: " + car.id);
        System.out.println("car name: " + car.name);
        System.out.println("car manufacturer: " + car.manufacturer);
        System.out.println("car type: " + car.type);
    }
    void findCarByManufacturer() {
        System.out.println("Enter car manufacturer: ");
        String carManufacturer = scanner.next();
        Car car = showroom.findByManufacturer(carManufacturer);

        System.out.println("car ID: " + car.id);
        System.out.println("car name: " + car.name);
        System.out.println("car manufacturer: " + car.manufacturer);
        System.out.println("car type: " + car.type);
    }
    void updateCarByManufacturer() {
        System.out.println("Update Car...");
        System.out.println("Enter Car manufacturer:");
        String carManufacturer = scanner.nextLine();

        Car car = showroom.findByManufacturer(carManufacturer);
        int carIndex = showroom.getAllCars().indexOf(car);

        System.out.println("Enter the new value of manufacturer");
        car.manufacturer = scanner.nextLine();

        showroom.updateCar(carIndex, car);
        System.out.println(car.manufacturer + "\nUpdated successfully");
    }
}





