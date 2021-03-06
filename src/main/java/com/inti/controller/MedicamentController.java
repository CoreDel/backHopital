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
	
	@GetMapping(value = "/medicaments/id/{idM}")
	public Medicament findOne(@PathVariable("idM") Long idMedicament) {
		return medicamentService.findOne(idMedicament);
	}
	
	@GetMapping(value = "/medicaments/{nomMedicament}")
	public List<Medicament> findByNomMedicament(@PathVariable("nomMedicament") String nomMedicament) {
		List<Medicament> medicaments = medicamentService.findByNomMedicament(nomMedicament);
		return medicaments;
	}
	
	@GetMapping(value = "/ordonnances/medicaments/{id_Ord}")
	public List<Medicament> findByIdOrdonnance(@PathVariable("id_Ord") Long idOrdonnance) {
		List<Medicament> medicaments = medicamentService.findByIdOrdonnance(idOrdonnance);
		return medicaments;
	}
	
	@PostMapping("/medicaments")
	public Medicament saveMedicament(@RequestBody Medicament medicament) {
		return medicamentService.save(medicament);
	}
	
	@PutMapping("/medicaments/{idM}")
	public Medicament updateMedicament(@PathVariable("idM") Long idMedicament, @RequestBody Medicament medicament) {
		Medicament currentMedicament = medicamentService.findOne(idMedicament);
		if(medicament.getNomMedicament() !=null) {
			currentMedicament.setNomMedicament(medicament.getNomMedicament());
		}
		if(medicament.getDescMedicament() !=null) {
			currentMedicament.setDescMedicament(medicament.getDescMedicament());
		}
		if(medicament.getQuantMedicament() !=null) {
			currentMedicament.setQuantMedicament(medicament.getQuantMedicament());
		}
		return medicamentService.save(currentMedicament);
	}
	
	
	@DeleteMapping("/medicaments/{idM}")
	public void deleteMedicament(@PathVariable("idM") Long idMedicament) {
		medicamentService.delete(idMedicament);
	}

}
