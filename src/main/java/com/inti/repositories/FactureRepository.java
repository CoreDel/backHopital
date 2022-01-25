package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Facture;
import com.inti.entities.Medicament;
import com.inti.entities.Utilisateur;

@Repository
public interface FactureRepository extends JpaRepository<Facture, Long> {
	Facture findByPrixAndType(Long prix, String type);
	
	Facture findByIdOrdonnance(Long idOrdonnance);
	
	//affiche facture par personne (nom et prenom)
	@Query(value = "SELECT * FROM facture WHERE id_ordonnance IN (SELECT id_ordonnance FROM ordonnance WHERE id_consultation IN (SELECT id_consultation FROM consultation WHERE id_patient IN (SELECT id_utilisateur FROM utilisateur WHERE nom_utilisateur = ?1 AND prenom_utilisateur = ?2))) ",
			nativeQuery = true)
	List<Facture> showFactureByNomAndPrenom(String nom, String prenom);
	
	
	

}
