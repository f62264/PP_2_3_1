package web.service;

import web.models.Car;

import java.util.List;

public interface CarService {
    public List<Car> getCars(List<Car> car, Integer count);
}
