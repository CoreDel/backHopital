package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Medicament;

public interface IMedicamentService {
	List<Medicament> findAll();
	
	Medicament findOneById(Long id);

	Medicament save(Medicament medicament);

	void delete(Long idMedicament);
	
	Long checkQuantityById(Long id);
	
	Long checkQuantityByName(String name);
}
