package com.example.dz_8_course_project_rest_api.controller;

import com.example.dz_8_course_project_rest_api.entity.Country;
import com.example.dz_8_course_project_rest_api.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    private CountryService countryService;

    @GetMapping
    public List<Country> getAllCountries(){
        return countryService.getAllCountries();
    }

    @GetMapping("/{id}")
    public Country getCountryById(@PathVariable int id){
        return countryService.getCountryById(id);
    }

    @PostMapping
    public Country addCountry(@RequestBody Country country){
        return countryService.saveOrUpdateCountry(country);
    }

    @PutMapping
    public Country updateCountry(@RequestBody Country country){
        return countryService.saveOrUpdateCountry(country);
    }

    @GetMapping("/name/{name}")
    public List<Country>getCountryByName(@PathVariable String name){
        return countryService.getCountryByName(name);
    }

    @DeleteMapping("/{id}")
    public String deleteCountryById(@PathVariable int id){
        String result;

        if(countryService.getCountryById(id)!=null){
            countryService.deleteCountryById(id);
            if(countryService.getCountryById(id)==null){
                result = "Country was deleted";
            }else {
                result = "Country was not deleted";
            }
        }else {
            result = "The id is not in the database"; // повідомлення у разі відсутності об'єкта з вказаним id у БД
        }
        return result;
    }


}
