package com.example.dz_8_course_project_rest_api.service;

import com.example.dz_8_course_project_rest_api.entity.Manager;
import com.example.dz_8_course_project_rest_api.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl  implements ManagerService{
    @Autowired
    private ManagerRepository managerRepository;
    @Override
    public List<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @Override
    public Manager saveOrUpdateManager(Manager manager) {
        return managerRepository.save(manager);
    }

    @Override
    public Manager getManagerById(int id) {
        return managerRepository.findById(id).orElse(null);
    }

    @Override
    public List<Manager> getManagerByLastName(String lastName) {
        return managerRepository.findAllByLastName(lastName);
    }

    @Override
    public void deleteManagerById(int id) {
        managerRepository.deleteById(id);
    }
}
