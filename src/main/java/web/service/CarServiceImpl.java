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
        if (count > 5) {
            count = 5;
        }
        return car.stream().limit(count).collect(Collectors.toList());
    }
}


