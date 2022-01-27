package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Facture;
import com.inti.repositories.FactureRepository;
import com.inti.service.interfaces.IFactureService;

@Service
public class FactureService implements IFactureService{
	@Autowired
	FactureRepository factureRepository;
	
	//findAll
	@Override
	public List<Facture> findAll() {
		return factureRepository.findAll();
	}

	//findOne
	@Override
	public Facture findOne(Long idFacture) {
		return factureRepository.findById(idFacture).get();
	}
	
	//save
	@Override
	public Facture save(Facture facture) {
		return factureRepository.save(facture);
	}

	//delete
	@Override
	public void delete(Long idFacture) {
		factureRepository.deleteById(idFacture);
	}

	//findBy
	@Override
	public Facture findByPrixAndType(Long prix, String type) {
		return factureRepository.findByPrixAndType(prix, type);
	}

	@Override
	public List<Facture> findByNomUtilisateurAndPrenomUtilisateur(String nomUtilisateur, String prenomUtilisateur) {
		return factureRepository.showFactureByNomAndPrenom(nomUtilisateur, prenomUtilisateur);
	}

	@Override
	public List<Facture> findByIdOrdonnance(Long idOrdonnance) {
		return factureRepository.findByIdOrdonnance(idOrdonnance);
	}

}