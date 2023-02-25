package com.example.dz_8_course_project_rest_api.service;

import com.example.dz_8_course_project_rest_api.entity.Client;

import java.util.List;

public interface ClientService {
    List<Client>getAllClients();

    Client saveOrUpdateClient(Client client);

    Client getClientById(int id);

    List<Client> getClientByLastName(String lastName);

    void deleteClientById(int id);
}
