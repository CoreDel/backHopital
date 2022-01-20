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

import com.inti.entities.Medicament;
import com.inti.service.interfaces.IMedicamentService;

@RestController
@CrossOrigin
public class MedicamentController {
	
	@Autowired
	IMedicamentService medicamentService;
	
	@GetMapping("/medicaments")
	public List<Medicament> findAll() {
		return medicamentService.findAll();
	}
	
	@GetMapping(value = "/medicaments/{idM}")
	public Medicament findOneById(@PathVariable("idM") Long idMedicament) {
		return medicamentService.findOneById(idMedicament);
	}
	
	@PostMapping("/medicaments")
	public Medicament saveMedicament(@RequestBody Medicament medicament) {
		return medicamentService.save(medicament);
	}
	
	@PutMapping("/medicaments/{idM}")
	public Medicament updateMedicament(@PathVariable("idM") Long idMedicament, @RequestBody Medicament medicament) {
		Medicament currentMedicament = medicamentService.findOneById(idMedicament);
		currentMedicament.setNomMedicament(medicament.getNomMedicament());
		currentMedicament.setDescMedicament(medicament.getDescMedicament());
		currentMedicament.setQuantMedicament(medicament.getQuantMedicament());
		return medicamentService.save(currentMedicament);
	}
	
	@DeleteMapping("/medicaments/{idM}")
	public void deleteMedicament(@PathVariable("idM") Long idMedicament) {
		medicamentService.delete(idMedicament);
	}

}
