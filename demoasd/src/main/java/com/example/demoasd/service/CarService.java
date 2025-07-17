package com.example.demoasd.service;

import com.example.demoasd.dto.CarCreateRequest;
import com.example.demoasd.model.Car;
import com.example.demoasd.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {

    private final CarRepository repo;

    public CarService(CarRepository repo) {
        this.repo = repo;
    }

    public Car addCar(CarCreateRequest req) {
        int finalPrice = req.getBasePrice() + req.getHorsePower() * 3;

        Car car = new Car();
        car.setName(req.getName());
        car.setAge(req.getAge());
        car.setHorsePower(req.getHorsePower());
        car.setBasePrice(req.getBasePrice());
        car.setFinalPrice(finalPrice);

        return repo.save(car);
    }
    public List<Car> getAllCars() {
        return repo.findAll();
    }

}
