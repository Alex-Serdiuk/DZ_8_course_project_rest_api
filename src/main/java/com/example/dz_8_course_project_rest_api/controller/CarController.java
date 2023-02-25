package com.example.dz_8_course_project_rest_api.controller;


import com.example.dz_8_course_project_rest_api.entity.Car;
import com.example.dz_8_course_project_rest_api.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    @GetMapping
    public List<Car>getAllCars(){
        return carService.getAllCars();
    }
    @GetMapping("/{id}")
    public Car getCarById(@PathVariable int id){
        return carService.getCarById(id);
    }

    @PostMapping
    public Car addCar(@RequestBody Car car){
        return carService.saveOrUpdateCar(car);
    }

    @PutMapping
    public Car updateCar(@RequestBody Car car){
        return carService.saveOrUpdateCar(car);
    }

    @GetMapping("/model/{name}")
    public List<Car>getCarsByModelName(@PathVariable String name){
        return carService.getCarByName(name);
    }

    @DeleteMapping("/{id}")
    public String deleteCarById(@PathVariable int id){
        String result;

        if(carService.getCarById(id)!=null){
            carService.deleteCarById(id);
            if(carService.getCarById(id)==null){
                result = "Car was deleted";
            }else {
                result = "Car was not deleted";
            }
        }else {
            result = "The id is not in the database"; // повідомлення у разі відсутності об'єкта з вказаним id у БД
        }
        return result;
    }
}
