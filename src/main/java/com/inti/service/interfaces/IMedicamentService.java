package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Medicament;

public interface IMedicamentService {
	List<Medicament> findAll();
	
	Medicament findOne(Long id);

	Medicament save(Medicament medicament);

	void delete(Long idMedicament);
	
	List<Medicament> findByNomMedicament(String nomMedicament);
}
