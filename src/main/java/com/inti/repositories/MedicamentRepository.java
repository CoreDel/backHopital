package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Medicament;
import com.inti.entities.Utilisateur;

@Repository
public interface MedicamentRepository extends JpaRepository<Medicament, Long>{
	List<Medicament> findByNomMedicament(String nomMedicament);
	
	@Query(value = "SELECT * FROM medicament WHERE id_medicament IN (SELECT id_med FROM profil_ord WHERE id_ord IN (SELECT id_ordonnance FROM ordonnance WHERE id_ordonnance = ?1 ));",
			nativeQuery = true)
	List<Medicament> showMedocById(Long idOrdonnance);
}
