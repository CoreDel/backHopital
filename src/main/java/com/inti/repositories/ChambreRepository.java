package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Chambre;
import com.inti.entities.Utilisateur;

@Repository
public interface ChambreRepository extends JpaRepository<Chambre, Long>{
	Chambre findBynumChambre(Long numChambre);
	
	@Query(value = "SELECT * FROM chambre WHERE dispo_chambre = 1 ",
			nativeQuery = true)
	List<Chambre> findDispoChambre();
}
