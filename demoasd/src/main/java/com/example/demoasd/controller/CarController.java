package com.example.demoasd.controller;

import com.example.demoasd.dto.CarCreateRequest;
import com.example.demoasd.model.Car;
import com.example.demoasd.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService service;

    public CarController(CarService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Car> addCar(@RequestBody CarCreateRequest request) {
        return ResponseEntity.ok(service.addCar(request));
    }
    @GetMapping
    public ResponseEntity<List<Car>> getAllCars() {
        return ResponseEntity.ok(service.getAllCars());
    }
}
