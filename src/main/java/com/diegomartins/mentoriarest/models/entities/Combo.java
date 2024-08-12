package com.diegomartins.mentoriarest.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
public class Combo {

    @Id
    private UUID id;

    private String name;
    private String description;
    private Double price;

    @OneToMany
    private List<ComboItem> Itens = new ArrayList<>();
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public List<ComboItem> getItens() {
        return Itens;
    }

    public void setItens(List<ComboItem> Itens) {
        this.Itens = Itens;
    }
}
