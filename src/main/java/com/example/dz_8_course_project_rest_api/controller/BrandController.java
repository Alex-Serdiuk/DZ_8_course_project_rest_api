package com.example.dz_8_course_project_rest_api.controller;

import com.example.dz_8_course_project_rest_api.entity.Brand;
import com.example.dz_8_course_project_rest_api.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brands")
public class BrandController {
    @Autowired
    private BrandService brandService;

    @GetMapping
    public List<Brand>getAllBrands(){
        return brandService.getAllBrands();
    }

    @GetMapping("/{id}")
    public Brand getBrandById(@PathVariable int id){
        return brandService.getBrandById(id);
    }

    @PostMapping
    public Brand addBrand(@RequestBody Brand brand){
        return brandService.saveOrUpdateBrand(brand);
    }

    @PutMapping
    public Brand updateBrand(@RequestBody Brand brand){
        return brandService.saveOrUpdateBrand(brand);
    }

    @GetMapping("/name/{name}")
    public List<Brand>getBrandsByName(@PathVariable String name){
        return brandService.getBrandByName(name);
    }

    @DeleteMapping("/{id}")
    public String deleteBrandById(@PathVariable int id){
        String result;

        if(brandService.getBrandById(id)!=null){
            brandService.deleteBrandyId(id);
            if(brandService.getBrandById(id)==null){
                result = "Brand was deleted";
            }else {
                result = "Brand was not deleted";
            }
        }else {
            result = "The id is not in the database"; // повідомлення у разі відсутності об'єкта з вказаним id у БД
        }
        return result;
    }
}
