package com.example.dz_8_course_project_rest_api.controller;

import com.example.dz_8_course_project_rest_api.entity.Service;
import com.example.dz_8_course_project_rest_api.service.ServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/services")
public class ServiceController {
    @Autowired
    private ServiceService serviceService;

    @GetMapping
    public List<Service>getAllService(){
        return serviceService.getAllServices();
    }

    @GetMapping("/{id}")
    public Service getServiceById(@PathVariable int id){
        return serviceService.getServiceById(id);
    }

    @PostMapping
    public Service addService(@RequestBody Service service){
        return serviceService.saveOrUpdateService(service);
    }

    @PutMapping
    public Service updateService(@RequestBody Service service){
        return serviceService.saveOrUpdateService(service);
    }

    @GetMapping("/name/{name}")
    public List<Service>getServicesByName(@PathVariable String name){
        return serviceService.getServiceByName(name);
    }

    @DeleteMapping("/{id}")
    public String deleteServiceById(@PathVariable int id){
        String result;

        if(serviceService.getServiceById(id)!=null){
            serviceService.deleteServiceById(id);
            if(serviceService.getServiceById(id)==null){
                result = "Service was deleted";
            }else {
                result = "Service was not deleted";
            }
        }else {
            result = "The id is not in the database"; // повідомлення у разі відсутності об'єкта з вказаним id у БД
        }
        return result;
    }
}
