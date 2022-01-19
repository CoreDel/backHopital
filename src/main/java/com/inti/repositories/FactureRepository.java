package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.inti.entities.Facture;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
	Facture findByPrixAndType(Long prix, String type);

}
