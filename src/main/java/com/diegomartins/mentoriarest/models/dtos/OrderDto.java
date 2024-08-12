package com.diegomartins.mentoriarest.models.dtos;

import com.diegomartins.mentoriarest.models.entities.OrderItem;

import java.util.List;

public record OrderDto(Double totalPrice, Double discount, List<OrderItem> orderItens) {
}
