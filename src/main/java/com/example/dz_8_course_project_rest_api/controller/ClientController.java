package com.example.dz_8_course_project_rest_api.controller;

import com.example.dz_8_course_project_rest_api.entity.Client;
import com.example.dz_8_course_project_rest_api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping("/clients")
    public List<Client>getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/clients/{id}")
    public Client getClientById(@PathVariable int id){
        return clientService.getClientById(id);
    }

    @PostMapping("/clients")
    public Client addClient(@RequestBody Client client){
        return clientService.saveOrUpdateClient(client);
    }

    @PutMapping("/clients")
    public  Client updateClient(@RequestBody Client client){
        return clientService.saveOrUpdateClient(client);
    }

    @GetMapping("/clients/last_name/{lastName}")
    public List<Client>getClientByLastName(@PathVariable String lastName){
        return clientService.getClientByLastName(lastName);
    }
}
