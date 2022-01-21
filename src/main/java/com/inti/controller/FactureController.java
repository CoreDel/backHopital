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
	
	//findBy
	@GetMapping(value = "/factures/{prix}/{type}")
	public Facture findByPrixAndType(@PathVariable("prix") Long prix,@PathVariable("type") String type) {
		return factureService.findByPrixAndType(prix, type);
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
		currentFacture.setPrix(facture.getPrix());	
		currentFacture.setType(facture.getType());
		currentFacture.setDescription(facture.getDescription());
		return factureService.save(currentFacture);	
	}
	
	//delete
	@DeleteMapping(value = "/factures/{idF}")
	public void deleteFacture(@PathVariable("idF") Long idFacture) {
		factureService.delete(idFacture);
	}
}