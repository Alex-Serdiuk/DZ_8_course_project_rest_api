package com.example.dz_8_course_project_rest_api.service;

import com.example.dz_8_course_project_rest_api.entity.Car;
import com.example.dz_8_course_project_rest_api.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    @Autowired
    private CarRepository carRepository;
    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car saveOrUpdateCar(Car car) {
        return carRepository.save(car);
    }

    @Override
    public Car getCarById(int id) {
        return carRepository.findById(id).orElse(null);
    }

    @Override
    public List<Car> getCarByName(String name) {
        return carRepository.findAllByModelName(name);
    }

    @Override
    public void deleteCarById(int id) {
        carRepository.deleteById(id);
    }
}
