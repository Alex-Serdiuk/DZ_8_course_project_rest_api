package com.example.dz_8_course_project_rest_api.service;

import com.example.dz_8_course_project_rest_api.entity.Brand;

import java.util.List;

public interface BrandService {
    List<Brand>getAllBrands();

    Brand saveOrUpdateBrand(Brand brand);

    Brand getBrandById(int id);

    List<Brand> getBrandByName(String name);

    void deleteBrandyId(int id);
}
