package web.Dao;

import org.springframework.stereotype.Service;
import web.Model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Override
    public List<Car> getCarById(int valueCar) {
        List<Car> cars = getCars();
        if (valueCar <= cars.size()) {
            List<Car> listCar = new ArrayList<>();
            for (int i = 0; i < valueCar; i++) {
                listCar.add(cars.get(i));
            }
            cars = listCar;
        }
        return cars;
    }

    private static List<Car> getCars() {
        List<Car> listCar = new ArrayList<>();
        listCar.add(new Car("1", "1", "1"));
        listCar.add(new Car("2", "2", "2"));
        listCar.add(new Car("3", "3", "3"));
        listCar.add(new Car("4", "4", "4"));
        listCar.add(new Car("5", "5", "5"));
        return listCar;
    }
}
