package com.diegomartins.mentoriarest.repositories;

import com.diegomartins.mentoriarest.models.entities.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface DishRepository extends JpaRepository<Dish, UUID> {

    List<Dish> findByNameContainingIgnoreCase(String dish);

    List<Dish> findByDescriptionContainingIgnoreCase(String description);

}
