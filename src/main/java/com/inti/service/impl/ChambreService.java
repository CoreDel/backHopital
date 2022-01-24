package com.inti.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Chambre;
import com.inti.repositories.ChambreRepository;
import com.inti.service.interfaces.IChambreService;

@Service
public class ChambreService implements IChambreService {
	
	@Autowired
	ChambreRepository chambreRepository;

	@Override
	public List<Chambre> findAll() {

		return chambreRepository.findAll();
	}

	@Override
	public Chambre findOne(Long idChambre) {
		
		return chambreRepository.findById(idChambre).get();
	}

	@Override
	public Chambre save(Chambre chambre) {
		
		return chambreRepository.save(chambre);
	}

	@Override
	public void delete(Long idChambre) {
		chambreRepository.deleteById(idChambre);

	}

	@Override
	public Chambre findByNumChambre(Long numChambre) {
		
		return chambreRepository.findBynumChambre(numChambre);
	}

	@Override
	public List<Chambre> findDispoChambre() {
		return chambreRepository.findDispoChambre();
	}

	

}
