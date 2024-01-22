package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {
    private static List<Car> cars;

    static {
        cars = new ArrayList<>();
        cars.add(new Car("model1", "brand1", 100500));
        cars.add(new Car("model2", "brand1", 999999));
        cars.add(new Car("model3", "brand1", 6453435));
        cars.add(new Car("model1", "brand2", 5455435));
        cars.add(new Car("model2", "brand2", 2173746));
    }

    public List<Car> findCars(int carAmount) {
        return cars.subList(0, Math.min(carAmount, cars.size()));
    }

    public List<Car> findCars() {
        return findCars(cars.size());
    }
}
