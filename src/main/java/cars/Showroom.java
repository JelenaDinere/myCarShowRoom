package cars;

import java.util.ArrayList;

public class Showroom {
    private ArrayList<Car>cars =new ArrayList<Car>();
    //add Car
    public String addCar(Car car){
        this.cars.add(car);
        return car.name + "\nAdded successfully";
    }
    //get AllClass;
    public ArrayList<Car> getAllCars() {

        return cars;
    }
    //get SingleCar;
    //public Car getSingleCar(int carIndex){
      //  return this.cars.get(carIndex);
    public String getSingleCar(int carIndex){
        try {
            Car car = this.cars.get(carIndex);
            return "Car Number: " + car.id + "\n Car Name: " + car.name + "\n Car Type: " + car.type;
        }catch (Exception ex){
            return "Unable to find car.Please try again with valid index!!!";
        }
    }
    //removeCar
    public String removeCar(int carIndex) {
        try {
            this.cars.remove(carIndex);
        }catch (Exception exc){
            return "Unable to remove specified car";
    }
        {
            return "Car removed";
        }
    }
}
