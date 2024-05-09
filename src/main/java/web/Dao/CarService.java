package web.Dao;

import web.Model.Car;

import java.util.List;

public interface CarService {
    List<Car> getCarById(int valueCar);
}
