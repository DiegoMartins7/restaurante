package com.diegomartins.mentoriarest.controllers;

import com.diegomartins.mentoriarest.models.dtos.DishDto;
import com.diegomartins.mentoriarest.models.entities.Dish;
import com.diegomartins.mentoriarest.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/dish")
public class DishController {

    private final DishService dishService;

    @Autowired
    public DishController(DishService dishService){
        this.dishService = dishService;
    }

    @PostMapping
    public Dish create(@RequestBody DishDto dishDto){
        return dishService.create(dishDto);
    }

    @GetMapping
    public List<Dish> findAll() {
        return dishService.findAll();
    }

    @GetMapping("/{id}")
    public Dish findById(@PathVariable UUID id){
        return dishService.findById(id);
    }

    @GetMapping("/dish/{dish}")
    public List<Dish> findByName(@PathVariable String dish){
        return dishService.findByName(dish);
    }

    @GetMapping("/description/{description}")
    public List<Dish> findByDescription(@PathVariable String description){
        return dishService.findByDescription(description);
    }

    @PutMapping("/{id}")
    public Dish update(@PathVariable UUID id, @RequestBody DishDto dishDto) {
        return dishService.updateDish(id, dishDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDish(@PathVariable UUID id) {
        dishService.deleteDish(id);
        return ResponseEntity.ok("Delete dish");
    }
}
