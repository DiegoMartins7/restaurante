package com.diegomartins.mentoriarest.models.dtos;

import com.diegomartins.mentoriarest.models.enums.MenuItem;

public record DishDto(String nameDish, String descriptionDish, double priceDish, MenuItem typeDish) {
}
