package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.models.Car;
import web.service.CarServiceImpl;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CarsController {

    private static List<Car> car = new ArrayList<>();
    private CarServiceImpl carServiceImpl;

    @Autowired
    public CarsController(CarServiceImpl carServiceImpl) {
        this.carServiceImpl = carServiceImpl;
    }

    @GetMapping(value = "/cars")
    public String printCar(@RequestParam(value = "count", defaultValue = "5") Integer count, Model model) {
        car.add(new Car(1, "q", "a"));
        car.add(new Car(2, "w", "b"));
        car.add(new Car(3, "r", "c"));
        car.add(new Car(4, "t", "d"));
        car.add(new Car(5, "y", "e"));
        model.addAttribute("cars", carServiceImpl.getCars(car, count));
        return "cars";
    }

}
