package com.diegomartins.mentoriarest.repositories;

import com.diegomartins.mentoriarest.models.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<Client, UUID> {

    List<Client> findByNameContainingIgnoreCase(String name);

    List<Client> findByDocumentContainingIgnoreCase(String document);

}
