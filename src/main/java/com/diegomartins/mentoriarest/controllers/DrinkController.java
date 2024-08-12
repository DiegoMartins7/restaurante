package com.diegomartins.mentoriarest.controllers;


import com.diegomartins.mentoriarest.models.dtos.DrinkDto;
import com.diegomartins.mentoriarest.models.entities.Drink;
import com.diegomartins.mentoriarest.service.DrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/drink")
public class DrinkController {

    private final DrinkService drinkService;

    @Autowired
    public DrinkController(DrinkService drinkService){
        this.drinkService = drinkService;
    }

    @PostMapping
    public Drink create(@RequestBody DrinkDto drinkDto){
        return drinkService.create(drinkDto);
    }

    @GetMapping
    public List<Drink> findAll() {
        return drinkService.findAll();
    }

    @GetMapping("/{id}")
    public Drink findById(@PathVariable UUID id){
        return drinkService.findById(id);
    }

    @GetMapping("/drink/{drink}")
    public List<Drink> findByName(@PathVariable String drink){
        return drinkService.findByName(drink);
    }

    @PutMapping("/{id}")
    public Drink update(@PathVariable UUID id, @RequestBody DrinkDto drinkDto) {
        return drinkService.updateDrink(id, drinkDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDrink(@PathVariable UUID id) {
        drinkService.deleteDrink(id);
        return ResponseEntity.ok("Delete drink");
    }

}
