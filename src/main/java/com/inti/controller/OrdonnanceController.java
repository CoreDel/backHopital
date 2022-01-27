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

import com.inti.entities.Ordonnance;
import com.inti.service.interfaces.IOrdonnanceService;

@RestController
@CrossOrigin
public class OrdonnanceController {

	@Autowired
	IOrdonnanceService ordonnanceService;
	
	@GetMapping("/ordonnances")
	public List<Ordonnance> findAll() {
		return ordonnanceService.findAll();
	}
	
	@GetMapping(value = "ordonnances/{idO}")
	public Ordonnance findOneById(@PathVariable("idO") Long idOrdonnance) {
		return ordonnanceService.findOne(idOrdonnance);
	}
	
	@GetMapping(value = "ordonnances/{nom}/{prenom}")
	public List<Ordonnance> findByNomUtilisateurAndPrenomUtilisateur(@PathVariable("nom") String nomUtilisateur, @PathVariable("prenom") String prenomUtilisateur) {
		return ordonnanceService.findByNomUtilisateurAndPrenomUtilisateur(nomUtilisateur, prenomUtilisateur);
	}
	
	@PostMapping("/ordonnances")
	public Ordonnance saveOrdonnance(@RequestBody Ordonnance ordonnance) {
		return ordonnanceService.save(ordonnance);
	}
	
	@PutMapping("/ordonnances/{idO}")
	public Ordonnance updateOrdonnance(@PathVariable("idO") Long idOrdonnance, @RequestBody Ordonnance ordonnance) {
		Ordonnance currentOrdonnance = ordonnanceService.findOne(idOrdonnance);
		if(ordonnance.getSoinPrescrit() != null)	{
			currentOrdonnance.setSoinPrescrit(ordonnance.getSoinPrescrit());
		}
		if(ordonnance.getFacture() != null)	{
			currentOrdonnance.setFacture(ordonnance.getFacture());
		}
		if(ordonnance.getMedicamentPrescrit() != null)	{
			currentOrdonnance.setMedicamentPrescrit(ordonnance.getMedicamentPrescrit());
		}
		return ordonnanceService.save(currentOrdonnance);
	}
	
	@DeleteMapping("/ordonnances/{idO}")
	public void deleteOrdonnance(@PathVariable("idO") Long idOrdonnance) {
		ordonnanceService.delete(idOrdonnance);
	}
}
