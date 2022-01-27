package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Facture;

public interface IFactureService {
	List<Facture> findAll();
	Facture findOne(Long idFacture);
	Facture save(Facture facture);
	void delete(Long idFacture);
	Facture findByPrixAndType(Long prix, String type);
	
	List<Facture> findByNomUtilisateurAndPrenomUtilisateur(String nomUtilisateur, String prenomUtilisateur);
	
	List<Facture> findByIdOrdonnance(Long idOrdonnance);
}
