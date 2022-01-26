package com.inti.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.DossierMedical;

@Repository
public interface DossierMedicalRepository extends JpaRepository<DossierMedical, Long>{
	DossierMedical findByNumeroSecu(Long numeroSecu);
	
	//affiche tout le dossier pour un patient
//	@Query(value = "")
}
