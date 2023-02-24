package com.example.dz_8_course_project_rest_api.repository;

import com.example.dz_8_course_project_rest_api.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClientRepository extends JpaRepository<Client, Integer> {
    List<Client> findAllByLastName(String lastName);
}
