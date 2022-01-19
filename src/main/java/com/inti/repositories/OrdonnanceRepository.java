package com.inti.repositories;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Medicament;
import com.inti.entities.Ordonnance;

@Repository
public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Long>{
	Ordonnance findOneById(Long id);
}
