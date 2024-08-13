package com.diegomartins.mentoriarest.models.dtos;

import com.diegomartins.mentoriarest.models.entities.ComboItem;
import com.diegomartins.mentoriarest.models.enums.ItemType;

import java.util.List;

public record ComboDto(String comboName, String comboDescription, double comboPrice, List<ComboItem> comboItens, ItemType itemType) {
}
