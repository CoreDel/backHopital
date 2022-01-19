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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Chambre;
import com.inti.service.interfaces.IChambreService;

@RestController
@CrossOrigin
public class ChambreController {
	@Autowired
	IChambreService chambreService;

	@GetMapping("/chambres")
	public List<Chambre> findAll() {
		return chambreService.findAll();
	}

	@RequestMapping(value = "chambres/{idC}", method = RequestMethod.GET)
	public Chambre findOne(@PathVariable("idC") Long idChambre) {
		return chambreService.findOne(idChambre);
	}

	@PostMapping("/chambres")
	public Chambre saveChambre(@RequestBody Chambre chambre) {
		return chambreService.save(chambre);
	}

	@PutMapping("/chambres/{idC}")
	public Chambre updateChambre(@PathVariable("idC") Long idChambre, @RequestBody Chambre chambre) {
		Chambre currentChambre = chambreService.findOne(idChambre);
		currentChambre.setNumChambre(chambre.getNumChambre());
		currentChambre.setDispoChambre(chambre.getDispoChambre());
		return chambreService.save(currentChambre);
	}

	@DeleteMapping("/chambre/ {idC]")
	public void deleteChambre(@PathVariable("idChambre") Long idChambre) {
		chambreService.delete(idChambre);
	}
	@GetMapping("/chambresDisponibles")
	public List<Chambre> findByDisponibilite(){
		return chambreService.findByDisponibilite();
	}
}

