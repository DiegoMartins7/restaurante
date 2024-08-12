package com.diegomartins.mentoriarest.service;

import com.diegomartins.mentoriarest.models.dtos.ClientDto;
import com.diegomartins.mentoriarest.models.entities.Client;
import com.diegomartins.mentoriarest.repositories.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientService {


    private final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public Client create(ClientDto clientDto) {
        Client client = new Client();
        client.setId(UUID.randomUUID());
        client.setName(clientDto.name());
        client.setDocument(clientDto.document());
        return clientRepository.save(client);
    }

    public Client findById(UUID id) {
        return clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public List<Client> findAll() {
        return clientRepository.findAll();
    }

    public List<Client> findByName(String name) {
        return clientRepository.findByNameContainingIgnoreCase(name);
    }

    public List<Client> findByDocument(String document) {
        return clientRepository.findByDocumentContainingIgnoreCase(document);
    }

    public void deleteClient(UUID id) {
        Client client = findById(id);
        clientRepository.delete(client);
    }

    public Client updateClient(UUID id, ClientDto clientDto) {
        Client client = clientRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        client.setName(clientDto.name());
        client.setDocument(clientDto.document());

        return clientRepository.save(client);
    }

}
