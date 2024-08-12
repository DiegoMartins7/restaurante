package com.diegomartins.mentoriarest.repositories;

import com.diegomartins.mentoriarest.models.entities.Drink;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DrinkRepository extends JpaRepository<Drink, UUID> {

    List<Drink> findByNameContainingIgnoreCase(String drink);

}


