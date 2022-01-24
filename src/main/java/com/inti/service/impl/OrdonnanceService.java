package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Ordonnance;
import com.inti.repositories.OrdonnanceRepository;

import com.inti.service.interfaces.IOrdonnanceService;

@Service
public class OrdonnanceService implements IOrdonnanceService {

	@Autowired
	OrdonnanceRepository ordonnanceRepository;

	@Override
	public List<Ordonnance> findAll() {
		return ordonnanceRepository.findAll();
	}

	@Override
	public Ordonnance save(Ordonnance ordonnance) {
		return ordonnanceRepository.save(ordonnance);
	}

	@Override
	public void delete(Long idOrdonnance) {
		ordonnanceRepository.deleteById(idOrdonnance);

	}

	@Override
	public Ordonnance findOne(Long id) {
		return ordonnanceRepository.findById(id).get();
	}

	@Override
	public List<Ordonnance> findByNomUtilisateurAndPrenomUtilisateur(String nomUtilisateur, String prenomUtilisateur) {
		return ordonnanceRepository.showOrdonnanceByNomAndPrenom(nomUtilisateur, prenomUtilisateur);
	}
}
