package com.example.dz_8_course_project_rest_api.controller;

import com.example.dz_8_course_project_rest_api.entity.Brand;
import com.example.dz_8_course_project_rest_api.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping("/brands")
    public List<Brand>getAllBrands(){
        return brandService.getAllBrands();
    }

    @GetMapping("/brands/{id}")
    public Brand getBrandById(@PathVariable int id){
        return brandService.getBrandById(id);
    }

    @PostMapping("/brands")
    public Brand addBrand(@RequestBody Brand brand){
        return brandService.saveOrUpdateBrand(brand);
    }

    @PutMapping("/brands")
    public Brand updateBrand(@RequestBody Brand brand){
        return brandService.saveOrUpdateBrand(brand);
    }

    @GetMapping("/brands/name/{name}")
    public List<Brand>getBrandsByName(@PathVariable String name){
        return brandService.getBrandByName(name);
    }
}
