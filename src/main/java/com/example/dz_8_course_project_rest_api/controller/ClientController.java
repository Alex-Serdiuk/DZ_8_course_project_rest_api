package com.example.dz_8_course_project_rest_api.controller;

import com.example.dz_8_course_project_rest_api.entity.Client;
import com.example.dz_8_course_project_rest_api.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public List<Client>getAllClients(){
        return clientService.getAllClients();
    }

    @GetMapping("/{id}")
    public Client getClientById(@PathVariable int id){
        return clientService.getClientById(id);
    }

    @PostMapping
    public Client addClient(@RequestBody Client client){
        return clientService.saveOrUpdateClient(client);
    }

    @PutMapping
    public  Client updateClient(@RequestBody Client client){
        return clientService.saveOrUpdateClient(client);
    }

    @GetMapping("/last_name/{lastName}")
    public List<Client>getClientByLastName(@PathVariable String lastName){
        return clientService.getClientByLastName(lastName);
    }

    @DeleteMapping("/{id}")
    public String deleteClientById(@PathVariable int id){
        String result;

        if(clientService.getClientById(id)!=null){
            clientService.deleteClientById(id);
            if(clientService.getClientById(id)==null){
                result = "Client was deleted";
            }else {
                result = "Client was not deleted";
            }
        }else {
            result = "The id is not in the database"; // повідомлення у разі відсутності об'єкта з вказаним id у БД
        }
        return result;
    }
}
