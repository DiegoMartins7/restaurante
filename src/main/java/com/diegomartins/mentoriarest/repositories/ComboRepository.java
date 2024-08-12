package com.diegomartins.mentoriarest.repositories;

import com.diegomartins.mentoriarest.models.entities.Combo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ComboRepository extends JpaRepository<Combo, UUID> {

    List<Combo> findByComboContainingIgnoreCase(String combo);

}
