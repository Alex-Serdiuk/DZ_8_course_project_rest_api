package com.example.dz_8_course_project_rest_api.service;

import com.example.dz_8_course_project_rest_api.entity.Car;

import java.util.List;

public interface CarService {
    List<Car>getAllCars();

    Car saveOrUpdateCar(Car car);

    Car getCarById(int id);

    List<Car> getCarByName(String name);

    void deleteCarById(int id);
}
