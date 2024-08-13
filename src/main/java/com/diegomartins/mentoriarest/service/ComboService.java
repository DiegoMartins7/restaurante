package com.diegomartins.mentoriarest.service;

import com.diegomartins.mentoriarest.models.dtos.ComboDto;
import com.diegomartins.mentoriarest.models.entities.Combo;
import com.diegomartins.mentoriarest.repositories.ComboRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ComboService {

    private final ComboRepository comboRepository;

    public ComboService(ComboRepository comboRepository) {
        this.comboRepository = comboRepository;
    }

    public Combo create (ComboDto comboDto){
        Combo combo = new Combo();
        combo.setId(UUID.randomUUID());
        combo.setName(comboDto.comboName());
        combo.setDescription(comboDto.comboDescription());
        combo.setPrice(comboDto.comboPrice());
        combo.setItens(comboDto.comboItens());

        return comboRepository.save(combo);
    }

    public Combo findById(UUID id) {
        return comboRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
    }

    public List<Combo> findAll() {
        return comboRepository.findAll();
    }

    public List<Combo> findByName(String combo) {
        return comboRepository.findByNameContainingIgnoreCase(combo);
    }

    public List<Combo> findByDescription(String description) {
        return comboRepository.findByDescriptionContainingIgnoreCase(description);
    }

    public void deleteCombo(UUID id) {
        Combo combo = findById(id);
        comboRepository.delete(combo);
    }

    public Combo updateCombo(UUID id, ComboDto comboDto) {
        Combo combo = comboRepository.findById(id).orElseThrow(() -> new RuntimeException("Not found"));
        combo.setName(comboDto.comboName());
        combo.setDescription(comboDto.comboDescription());
        combo.setItens(comboDto.comboItens());
        combo.setPrice(comboDto.comboPrice());

        return comboRepository.save(combo);
    }
}
