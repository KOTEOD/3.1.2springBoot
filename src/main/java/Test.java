import org.springframework.ui.Model;
import web.Model.Car;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Car> listCar = new ArrayList<>();
        listCar.add(new Car("1","1","1"));
        listCar.add(new Car("2","2","2"));
        listCar.add(new Car("3","3","3"));
        listCar.add(new Car("4","4","4"));
        listCar.add(new Car("5","5","5"));
        Test test = new Test();
        System.out.println(test.getCarById(listCar,4));
    }

    public List<Car> getCarById(List<Car> cars, int valueCar) {
        List<Car> listCar = new ArrayList<>();
        for (int i = 0; i < valueCar; i++) {
            listCar.add(cars.get(i));
        }
        cars = listCar;
        return cars;
    }
}
