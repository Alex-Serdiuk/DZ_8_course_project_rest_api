package com.example.dz_8_course_project_rest_api.service;

import com.example.dz_8_course_project_rest_api.entity.Manager;

import java.util.List;

public interface ManagerService {
    List<Manager>getAllManagers();

    Manager saveOrUpdateManager(Manager manager);

    Manager getManagerById(int id);

    List<Manager> getManagerByLastName(String lastName);
}
