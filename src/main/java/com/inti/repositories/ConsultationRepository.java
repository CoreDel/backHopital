package com.inti.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Consultation;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
	List<Consultation> findByDate(Date date);
	
	// affiche consultation par ordonnance(id)
	@Query( value = "SELECT * FROM consultation WHERE id_consultation IN (SELECT id_consultation FROM ordonnance WHERE id_ordonnance = ?1)",
			nativeQuery = true)
	List<Consultation> showConsultationById(Long id);
	
	// affiche consultation par patient(username)
	@Query( value = "SELECT * FROM consultation WHERE id_patient IN (SELECT id_utilisateur FROM utilisateur WHERE username = ?1)",
			nativeQuery = true)
	List<Consultation> showConsultationByUsernamePatient(String username);
}