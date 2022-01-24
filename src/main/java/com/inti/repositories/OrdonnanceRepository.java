package com.inti.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Medicament;
import com.inti.entities.Ordonnance;
import com.inti.entities.Utilisateur;

@Repository
public interface OrdonnanceRepository extends JpaRepository<Ordonnance, Long>{
	
	@Query(value = "SELECT * FROM ordonnance WHERE id_consultation IN (SELECT id_consultation FROM consultation WHERE id_patient IN (SELECT id_utilisateur FROM utilisateur WHERE nom_utilisateur = ?1 AND prenom_utilisateur = ?2));",
			nativeQuery = true)
	List<Ordonnance> showOrdonnanceByNomAndPrenom(String nom, String prenom);
	
}


