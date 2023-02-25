package com.example.dz_8_course_project_rest_api.service;

import com.example.dz_8_course_project_rest_api.entity.Service;

import java.util.List;

public interface ServiceService {
    List<Service>getAllServices();

    Service saveOrUpdateService(Service service);

    Service getServiceById(int id);

    List<Service> getServiceByName(String name);

    void deleteServiceById(int id);
}
