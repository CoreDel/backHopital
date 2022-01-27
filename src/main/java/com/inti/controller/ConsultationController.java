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
	@RequestMapping(value="ordonnances/consultations/{idO}", method = RequestMethod.GET)
	public List<Consultation> findByIdOrdonnance(@PathVariable("idO") Long idOrdonnance) {
		return consultationService.findByIdOrdonnance(idOrdonnance);
	}
	
	//find by username patient
	@RequestMapping(value="ordonnances/consultationsPatient/{username}", method = RequestMethod.GET)
	public List<Consultation> showConsultationByUsernamePatient(@PathVariable("username") String usernamePatient) {
		return consultationService.showConsultationByUsernamePatient(usernamePatient);
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
        if(consultation.getIdPatient() != 0) {
        	currentConsultation.setIdPatient(consultation.getIdPatient());
        }
        if(consultation.getIdMedecin() != 0) {
            currentConsultation.setIdMedecin(consultation.getIdMedecin());
        }
        if(consultation.getMotifConsultation() != null) {
            currentConsultation.setMotifConsultation(consultation.getMotifConsultation());
        }
        if(consultation.getDate() != null) {
        	currentConsultation.setDate(consultation.getDate());
        }
         
        return consultationService.save(currentConsultation);
    }
	
}
