package com.example.dz_8_course_project_rest_api.service;

import com.example.dz_8_course_project_rest_api.entity.Client;
import com.example.dz_8_course_project_rest_api.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements ClientService{
    @Autowired
    private ClientRepository clientRepository;
    @Override
    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    @Override
    public Client saveOrUpdateClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client getClientById(int id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public List<Client> getClientByLastName(String lastName) {
        return clientRepository.findAllByLastName(lastName);
    }
}
