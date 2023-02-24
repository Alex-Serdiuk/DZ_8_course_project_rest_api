package com.example.dz_8_course_project_rest_api.controller;


import com.example.dz_8_course_project_rest_api.entity.Car;
import com.example.dz_8_course_project_rest_api.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping("/cars")
    public List<Car>getAllCars(){
        return carService.getAllCars();
    }
    @GetMapping("/cars/{id}")
    public Car getCarById(@PathVariable int id){
        return carService.getCarById(id);
    }

    @PostMapping("/cars")
    public Car addCar(@RequestBody Car car){
        return carService.saveOrUpdateCar(car);
    }

    @PutMapping("/cars")
    public Car updateCar(@RequestBody Car car){
        return carService.saveOrUpdateCar(car);
    }

    @GetMapping("/cars/model/{name}")
    public List<Car>getCarsByModelName(@PathVariable String name){
        return carService.getCarByName(name);
    }
}
