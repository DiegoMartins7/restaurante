package com.diegomartins.mentoriarest.models.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;
import java.util.UUID;

@Entity
public class Order {

    @Id
    private UUID id;
    private Double totalPrice;

    @OneToMany
    private List<OrderItem> OrderItens;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<OrderItem> getOrderItens() {
        return OrderItens;
    }

    public void setOrderItens(List<OrderItem> OrderItens) {
        this.OrderItens = OrderItens;
    }


}
