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
    }

    void showMenu(){

        String userInput = "";
        do {
            System.out.println("Welcome to the showroom, please choose activity: ");
            System.out.println("1. Add Car");
            System.out.println("2. View All Cars");
            System.out.println("3.View Single Car");
            System.out.println("4. Remove Car");
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
                case"3":
                    viewSingleCar();
                    break;
                case"4":
                    removeCar();
                    break;
                default:
                    break;
            }
        } while(!userInput.equalsIgnoreCase("Quit"));
            return;
        }
        void addCar(){

            System.out.println("Add Car");
            Car car = new Car();

            System.out.println("Enter Name:");
            car.name=scanner.nextLine();

            System.out.println("Enter Manufacturer");
            car.manufacturer=scanner.nextLine();

            System.out.println("Enter Type:");
            car.type =scanner.nextLine();

            car.id = UUID.randomUUID();
            String message =showroom.addCar(car);
            System.out.println(message);

    }
    void viewAllCars(){
        ArrayList<Car> allCars = showroom.getAllCars();
        System.out.println("All Available Cars");
        System.out.println("CarName \t Manufacturer \t CarType");
        for(Car car:allCars){
            System.out.println(car.name  + '\t'+ car.manufacturer + '\t'+ car.type);
        }
    }
    void viewSingleCar() {
        System.out.println("View single");
        System.out.println("Please provide car Index");

        int carIndex = scanner.nextInt();
        String message = showroom.getSingleCar(carIndex);
        System.out.println(message);
//        Car car = showroom.getSingleCar(carIndex);
//        System.out.println("Car Number"+ car.id);
//        System.out.println("Car Name"+ car.name);
//        System.out.println("Car Type"+ car.type);

    }
    void removeCar(){

        System.out.println("Enter car ID to remove");
        int carIndex = scanner.nextInt();
        String car =showroom.removeCar(carIndex);
        System.out.println(car);




    }
    //This is comment on the server
}
