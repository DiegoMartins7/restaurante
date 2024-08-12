package com.diegomartins.mentoriarest.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Drink extends MenuItens {

    @Id
    private UUID id;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

}
