package com.diegomartins.mentoriarest.controllers;

import com.diegomartins.mentoriarest.models.dtos.ClientDto;
import com.diegomartins.mentoriarest.models.entities.Client;
import com.diegomartins.mentoriarest.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/client")
public class ClientController {

    private final ClientService clientService;

    @Autowired
    public ClientController(ClientService clientService) {
        this.clientService = clientService;
    }

    @PostMapping
    public Client create(@RequestBody ClientDto clientDto) {
        return clientService.create(clientDto);
    }

    @GetMapping
    public List<Client> findAll() {
        return clientService.findAll();
    }

    @GetMapping("/{id}")
    public Client findById(@PathVariable UUID id) {
        return clientService.findById(id);
    }

    @GetMapping("/name/{name}")
    public List<Client> findByName(@PathVariable String name) {
        return clientService.findByName(name);
    }

    @GetMapping("/document/{document}")
    public List<Client> findByDocument(@PathVariable String document) {
        return clientService.findByDocument(document);
    }

    @PutMapping("/{id}")
    public Client update(@PathVariable UUID id,@RequestBody ClientDto clientDto) {
        return clientService.updateClient(id, clientDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteClient(@PathVariable UUID id) {
        clientService.deleteClient(id);
        return ResponseEntity.ok("Delete client");
    }



}
