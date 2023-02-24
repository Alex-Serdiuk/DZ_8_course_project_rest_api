package com.example.dz_8_course_project_rest_api.service;

import com.example.dz_8_course_project_rest_api.repository.ServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceServiceImpl implements ServiceService {
    @Autowired
    private ServiceRepository serviceRepository;

    @Override
    public List<com.example.dz_8_course_project_rest_api.entity.Service> getAllServices() {
        return serviceRepository.findAll();
    }

    @Override
    public com.example.dz_8_course_project_rest_api.entity.Service saveOrUpdateService(com.example.dz_8_course_project_rest_api.entity.Service service) {
        return serviceRepository.save(service);
    }

    @Override
    public com.example.dz_8_course_project_rest_api.entity.Service getServiceById(int id) {
        return serviceRepository.findById(id).orElse(null);
    }

    @Override
    public List<com.example.dz_8_course_project_rest_api.entity.Service> getServiceByName(String name) {
        return serviceRepository.findAllByServiceName(name);
    }
}
