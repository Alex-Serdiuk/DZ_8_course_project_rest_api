package com.example.dz_8_course_project_rest_api.controller;

import com.example.dz_8_course_project_rest_api.entity.Manager;
import com.example.dz_8_course_project_rest_api.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping("/managers")
    public List<Manager>getAllManagers(){
        return managerService.getAllManagers();
    }

    @GetMapping("/managers/{id}")
    public Manager getManagerById(@PathVariable int id){
        return managerService.getManagerById(id);
    }

    @PostMapping("/managers")
    public Manager addManager(@RequestBody Manager manager){
        return managerService.saveOrUpdateManager(manager);
    }

    @PutMapping("/managers")
    public Manager updateManager(@RequestBody Manager manager){
        return managerService.saveOrUpdateManager(manager);
    }

    @GetMapping("/managers/last_name/{lastName}")
    public List<Manager>getManagersByLastName(@PathVariable String lastName){
        return managerService.getManagerByLastName(lastName);
    }
}
