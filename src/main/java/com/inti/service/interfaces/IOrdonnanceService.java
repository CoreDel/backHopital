package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Ordonnance;

public interface IOrdonnanceService {
	List<Ordonnance> findAll();

	Ordonnance findOne(Long id);

	Ordonnance save(Ordonnance ordonnance);

	void delete(Long idOrdonnance);
}
