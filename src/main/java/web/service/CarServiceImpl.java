package web.service;

import org.springframework.stereotype.Component;
import web.models.Car;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CarServiceImpl implements CarService {

    @Override
    public List<Car> getCars(List<Car> car, Integer count) {
        return (count >= 5) ? car : car.subList(0, count);
    }
}


