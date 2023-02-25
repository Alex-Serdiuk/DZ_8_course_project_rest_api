package com.example.dz_8_course_project_rest_api.controller;

import com.example.dz_8_course_project_rest_api.entity.Manager;
import com.example.dz_8_course_project_rest_api.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/managers")
public class ManagerController {
    @Autowired
    private ManagerService managerService;

    @GetMapping
    public List<Manager>getAllManagers(){
        return managerService.getAllManagers();
    }

    @GetMapping("/{id}")
    public Manager getManagerById(@PathVariable int id){
        return managerService.getManagerById(id);
    }

    @PostMapping
    public Manager addManager(@RequestBody Manager manager){
        return managerService.saveOrUpdateManager(manager);
    }

    @PutMapping
    public Manager updateManager(@RequestBody Manager manager){
        return managerService.saveOrUpdateManager(manager);
    }

    @GetMapping("/last_name/{lastName}")
    public List<Manager>getManagersByLastName(@PathVariable String lastName){
        return managerService.getManagerByLastName(lastName);
    }

    @DeleteMapping("/{id}")
    public String deleteManagerById(@PathVariable int id){
        String result;

        if(managerService.getManagerById(id)!=null){
            managerService.deleteManagerById(id);
            if(managerService.getManagerById(id)==null){
                result = "Manager was deleted";
            }else {
                result = "Manager was not deleted";
            }
        }else {
            result = "The id is not in the database"; // повідомлення у разі відсутності об'єкта з вказаним id у БД
        }
        return result;
    }
}
