package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import web.Dao.CarService;
import web.Model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController implements CarService {
    @GetMapping("/cars")
    public String cars(Model model) {
        List<Car> listCar = new ArrayList<>();
        listCar.add(new Car("1", "1", "1"));
        listCar.add(new Car("2", "2", "2"));
        listCar.add(new Car("3", "3", "3"));
        listCar.add(new Car("4", "4", "4"));
        listCar.add(new Car("5", "5", "5"));
        model.addAttribute("messageACar", getCarById(listCar, 3));
        return "cars";
    }

    @Override
    public List<Car> getCarById(List<Car> cars, int valueCar) {
        if (valueCar > cars.size()) {
            return cars;
        }else {
            List<Car> listCar = new ArrayList<>();
            for (int i = 0; i < valueCar; i++) {
                listCar.add(cars.get(i));
            }
            cars = listCar;
            return cars;
        }
    }
}
