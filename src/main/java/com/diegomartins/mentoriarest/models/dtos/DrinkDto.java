package com.diegomartins.mentoriarest.models.dtos;

import com.diegomartins.mentoriarest.models.enums.MenuItem;

public record DrinkDto(String nameDrink, double priceDrink, MenuItem typeDrink) {
}
