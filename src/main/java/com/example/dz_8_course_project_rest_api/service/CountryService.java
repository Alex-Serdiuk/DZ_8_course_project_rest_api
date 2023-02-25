package com.example.dz_8_course_project_rest_api.service;

import com.example.dz_8_course_project_rest_api.entity.Country;

import java.util.List;

public interface CountryService {
    List<Country> getAllCountries();

    Country saveOrUpdateCountry(Country country);

    Country getCountryById(int id);

    List<Country> getCountryByName(String name);

    void deleteCountryById(int id);
}
