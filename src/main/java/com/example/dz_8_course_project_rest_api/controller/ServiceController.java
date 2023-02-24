package com.example.dz_8_course_project_rest_api.controller;

import com.example.dz_8_course_project_rest_api.entity.Service;
import com.example.dz_8_course_project_rest_api.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @GetMapping("/services")
    public List<Service>getAllService(){
        return serviceService.getAllServices();
    }

    @GetMapping("/services/{id}")
    public Service getServiceById(@PathVariable int id){
        return serviceService.getServiceById(id);
    }

    @PostMapping("/services")
    public Service addService(@RequestBody Service service){
        return serviceService.saveOrUpdateService(service);
    }

    @PutMapping("/services")
    public Service updateService(@RequestBody Service service){
        return serviceService.saveOrUpdateService(service);
    }

    @GetMapping("/services/name/{name}")
    public List<Service>getServicesByName(@PathVariable String name){
        return serviceService.getServiceByName(name);
    }
}
