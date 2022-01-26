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

import com.inti.entities.Consultation;
import com.inti.service.interfaces.IConsultationService;

@RestController
@CrossOrigin
public class ConsultationController {

	@Autowired
	IConsultationService consultationService;

	//find all
	@GetMapping(value = "/consultations")
	public List<Consultation> findAll(){
		return consultationService.findAll();
	}
	
	//find one
	@GetMapping(value="/consultations/{idC}")
	public Consultation findOne(@PathVariable("idC") Long idConsultation) {
		return consultationService.findOne(idConsultation);
	}
	
	//findBy (idOrdonnance)
	@GetMapping(value="/ordonnances/consultations/{idO}")
	public Consultation findByIdOrdonnance(@PathVariable("idO") Long idOrdonnance) {
		return consultationService.findByIdOrdonnance(idOrdonnance);
	}
	
	//sauvegarder
	@PostMapping (value = "/consultations")
	public Consultation saveConsultation(@RequestBody Consultation consultation) {
		return consultationService.save(consultation);
	}
	
	//supprimer
	@DeleteMapping(value = "/consultations/{idConsultation}")
	public void deleteConsultation(@PathVariable("idConsultation") Long idConsultation) {
		consultationService.delete(idConsultation);
	}
	
	//verification de la sauvegarde
	/*
	@PostMapping(value = "/consultations")
	public String saveConsultation (
			@RequestParam(name = "idConsultation", required=false) Long idConsultation, 
			@RequestParam(name = "idPatient",required = false) Long idPatient,
			@RequestParam(name = "idMedecin",required = false) Long idMedecin,
			@RequestParam(name = "motifConsultation",required = false) String motifConsultation,
			@RequestParam(name = "date",required = false) Date date){
		try {
			Consultation currentUser = new Consultation(); 
			currentUser.setIdConsultation(idConsultation);
			currentUser.setIdPatient(idPatient);
			currentUser.setIdMedecin(idMedecin);
			currentUser.setMotifConsultation(motifConsultation);
			currentUser.setDate(date);
			consultationService.save(currentUser);
			return "Consultation ajoutée avec succée";
	    }
		catch(Exception ex) {
	        ex.printStackTrace();
	        return "La consultation n'a pas pu être ajoutée";
		}
	}*/
	
	//mettre à jour une consultation
    @PutMapping(value="consultations/{idc}")
    public Consultation updateConsultation(@PathVariable("idc") Long idConsultation,
            @RequestBody Consultation consultation) {
        Consultation currentConsultation = consultationService.findOne(idConsultation);                                                                              
        currentConsultation.setIdConsultation(consultation.getIdConsultation());
        currentConsultation.setIdPatient(consultation.getIdPatient());
        currentConsultation.setIdMedecin(consultation.getIdMedecin());
        currentConsultation.setMotifConsultation(consultation.getMotifConsultation());
        currentConsultation.setDate(consultation.getDate());
        
        return consultationService.save(currentConsultation);
    }
	
}
