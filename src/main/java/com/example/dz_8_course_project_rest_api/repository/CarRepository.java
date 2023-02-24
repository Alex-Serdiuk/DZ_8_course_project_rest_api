package com.example.dz_8_course_project_rest_api.repository;

import com.example.dz_8_course_project_rest_api.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarRepository extends JpaRepository<Car, Integer> {
    List<Car> findAllByModelName(String name);
}
