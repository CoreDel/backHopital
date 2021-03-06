package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Chambre;

public interface IChambreService {
	
	List<Chambre> findAll();

	Chambre findOne(Long idChambre);

	Chambre save(Chambre chambre);

	void delete(Long idChambre);

	List<Chambre> findByNumChambre(Long numChambre);
	
	List<Chambre> findDispoChambre();
	
	Integer nombreDispoChambre();
}
