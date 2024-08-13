package com.diegomartins.mentoriarest.controllers;

import com.diegomartins.mentoriarest.models.dtos.ComboDto;
import com.diegomartins.mentoriarest.models.entities.Combo;
import com.diegomartins.mentoriarest.service.ComboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/combo")
public class ComboController {

    private final ComboService comboService;

    @Autowired
    public ComboController(ComboService comboService){
        this.comboService = comboService;
    }

    @PostMapping
    public Combo create(@RequestBody ComboDto comboDto){
        return comboService.create(comboDto);
    }

    @GetMapping
    public List<Combo> findAll() {
        return comboService.findAll();
    }

    @GetMapping("/{id}")
    public Combo findById(@PathVariable UUID id){
        return comboService.findById(id);
    }

    @GetMapping("/combo/{combo}")
    public List<Combo> findByName(@PathVariable String combo){
        return comboService.findByName(combo);
    }

    @GetMapping("/description/{description}")
    public List<Combo> findByDescription(@PathVariable String description){
        return comboService.findByDescription(description);
    }

    @PutMapping("/{id}")
    public Combo update(@PathVariable UUID id, @RequestBody ComboDto comboDto) {
        return comboService.updateCombo(id, comboDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCombo(@PathVariable UUID id) {
        comboService.deleteCombo(id);
        return ResponseEntity.ok("Delete combo");
    }
}
