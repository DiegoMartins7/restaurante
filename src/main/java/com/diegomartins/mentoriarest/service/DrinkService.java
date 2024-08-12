package com.diegomartins.mentoriarest.service;

import com.diegomartins.mentoriarest.models.dtos.DrinkDto;
import com.diegomartins.mentoriarest.models.entities.Drink;
import com.diegomartins.mentoriarest.repositories.DrinkRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DrinkService {

        private final DrinkRepository drinkRepository;

        public DrinkService(DrinkRepository drinkRepository) {
            this.drinkRepository = drinkRepository;
    }

    public Drink create (DrinkDto drinkDto){
        Drink drink = new Drink();
        drink.setId(UUID.randomUUID());
        drink.setName(drinkDto.nameDrink());
        drink.setPrice(drinkDto.priceDrink());
        drink.setMenuItem(drinkDto.typeDrink());
        return drinkRepository.save(drink);
    }

    public Drink findById(UUID id) {
        return drinkRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public List<Drink> findAll() {
        return drinkRepository.findAll();
    }

    public List<Drink> findByName(String dish) {
        return drinkRepository.findByNameContainingIgnoreCase(dish);
    }

    public void deleteDrink(UUID id) {
        Drink drink = findById(id);
        drinkRepository.delete(drink);
    }

    public Drink updateDrink(UUID id, DrinkDto drinkDto) {
        Drink drink = drinkRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        drink.setName(drinkDto.nameDrink());

        return drinkRepository.save(drink);
    }
}
