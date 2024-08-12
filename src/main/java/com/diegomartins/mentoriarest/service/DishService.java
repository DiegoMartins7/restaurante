package com.diegomartins.mentoriarest.service;


import com.diegomartins.mentoriarest.models.dtos.DishDto;
import com.diegomartins.mentoriarest.models.entities.Dish;
import com.diegomartins.mentoriarest.repositories.DishRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DishService {

    private final DishRepository dishRepository;

    public DishService(DishRepository dishRepository) {
        this.dishRepository = dishRepository;
    }

    public Dish create (DishDto dishDto){
        Dish dish = new Dish();
        dish.setId(UUID.randomUUID());
        dish.setName(dishDto.nameDish());
        dish.setDescription(dishDto.descriptionDish());
        dish.setPrice(dishDto.priceDish());
        dish.setMenuItem(dishDto.typeDish());
        return dishRepository.save(dish);
    }

    public Dish findById(UUID id) {
        return dishRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public List<Dish> findAll() {
        return dishRepository.findAll();
    }

    public List<Dish> findByName(String dish) {
        return dishRepository.findByNameContainingIgnoreCase(dish);
    }

    public List<Dish> findByDescription(String description) {
        return dishRepository.findByDescriptionContainingIgnoreCase(description);
    }

    public void deleteDish(UUID id) {
        Dish dish = findById(id);
        dishRepository.delete(dish);
    }

    public Dish updateDish(UUID id, DishDto dishDto) {
        Dish dish = dishRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        dish.setName(dishDto.nameDish());
        dish.setDescription(dishDto.descriptionDish());

        return dishRepository.save(dish);
    }
}
