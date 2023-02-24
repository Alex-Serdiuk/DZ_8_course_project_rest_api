package com.example.dz_8_course_project_rest_api.service;

import com.example.dz_8_course_project_rest_api.entity.Country;
import com.example.dz_8_course_project_rest_api.repository.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService{
    @Autowired
    private CountryRepository countryRepository;
    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Override
    public Country saveOrUpdateCountry(Country country) {
        return countryRepository.save(country);
    }

    @Override
    public Country getCountryById(int id) {
        return countryRepository.findById(id).orElse(null);
    }

    @Override
    public List<Country> getCountryByName(String name) {
        return countryRepository.findAllByCountryName(name);
    }
}
