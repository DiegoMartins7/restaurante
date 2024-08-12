package com.diegomartins.mentoriarest.models.entities;

import com.diegomartins.mentoriarest.models.enums.ItemType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.UUID;

@Entity
public class ComboItem extends MenuItens{

    @Id
    private UUID id;

    private UUID itemId;
    private ItemType itemType;
    private String description;


    @ManyToOne
    private Combo combo;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getItemId() {
        return itemId;
    }

    public void setItemId(UUID itemId) {
        this.itemId = itemId;
    }

    public ItemType getItemType() {
        return itemType;
    }

    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Combo getCombo() {
        return combo;
    }

    public void setCombo(Combo combo) {
        this.combo = combo;
    }
}
