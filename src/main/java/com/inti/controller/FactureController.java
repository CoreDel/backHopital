package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Facture;
import com.inti.service.interfaces.IFactureService;


@RestController
@CrossOrigin 
public class FactureController {
	@Autowired
	IFactureService factureService;
	
	//findAll
	@GetMapping(value="/factures")
	public List<Facture> findAll(){
		return factureService.findAll();
	}
	
	//findOne
	@GetMapping(value = "/factures/{idF}")
	public Facture findOne(@PathVariable("idF") Long idFacture) {
		return factureService.findOne(idFacture);
	}
	
	//findBy (prix et type)
	@GetMapping(value = "/factures/{prix}/{type}")
	public Facture findByPrixAndType(@PathVariable("prix") Long prix,@PathVariable("type") String type) {
		return factureService.findByPrixAndType(prix, type);
	}
	
	//findByNomUtilisateurAndPrenomUtilisateur
	@GetMapping(value = "/factures/utilisateurs/{nom}/{prenom}")
	public List<Facture> findByNomUtilisateurAndPrenomUtilisateur(@PathVariable("nom") String nomUtilisateur,@PathVariable("prenom") String prenomUtilisateur) {
		return factureService.findByNomUtilisateurAndPrenomUtilisateur(nomUtilisateur, prenomUtilisateur);
	}
	
	//findBy (idOrdonnance)
	@GetMapping(value = "/ordonnances/factures/{idO}")
	public List<Facture> findByIdOrdonnance(@PathVariable("idO") Long idOrdonnance) {
		return factureService.findByIdOrdonnance(idOrdonnance);
	}
	
	//save
	@PostMapping(value = "/factures")
	public Facture saveFacture(@RequestBody Facture facture){
		return factureService.save(facture);
	}
	
	//update
	@PutMapping(value="/factures/{idF}")
	public Facture updateFacture(@PathVariable("idF") Long idFacture, @RequestBody Facture facture) {
		Facture currentFacture=factureService.findOne(idFacture); 
		if (facture.getPrix() != 0)	{
			currentFacture.setPrix(facture.getPrix());	
		}
		if (facture.getType() != null)	{
			currentFacture.setType(facture.getType());
		}
		if (facture.getDescription() != null)	{
			currentFacture.setDescription(facture.getDescription());
		}
		return factureService.save(currentFacture);	
	}
	
	//delete
	@DeleteMapping(value = "/factures/{idF}")
	public void deleteFacture(@PathVariable("idF") Long idFacture) {
		factureService.delete(idFacture);
	}
}