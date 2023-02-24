package com.example.dz_8_course_project_rest_api.repository;

import com.example.dz_8_course_project_rest_api.entity.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BrandRepository extends JpaRepository<Brand, Integer> {
    List<Brand> findAllByBrandName(String name);
}
