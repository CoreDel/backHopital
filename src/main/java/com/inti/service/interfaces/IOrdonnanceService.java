package com.inti.service.interfaces;

import java.util.List;
import java.util.Set;

import com.inti.entities.Medicament;
import com.inti.entities.Ordonnance;


public interface IOrdonnanceService {
	List<Ordonnance> findAll();
	
	Ordonnance findOneById(Long id);

	Ordonnance save(Ordonnance ordonnance);

	void delete(Long idOrdonnance);
}
