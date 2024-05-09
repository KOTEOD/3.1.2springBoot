package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import web.Dao.CarService;
import web.Dao.CarServiceImpl;
import web.Model.Car;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    private final CarService carService;
    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars/{count}")
    public String cars(Model model,@PathVariable int count) {
        List<Car> result = carService.getCarById(count);
        model.addAttribute("carList",result);
        return "cars";
    }
}
