package com.inti.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Consultation;
import com.inti.service.interfaces.IConsultationService;

@RestController
@CrossOrigin
public class ConsultationController {

	@Autowired
	IConsultationService consultationService;

	//find all
	@RequestMapping(value = "consultations", method = RequestMethod.GET)
	public List<Consultation> findAll(){
		return consultationService.findAll();
	}
	
	//find one
	@RequestMapping(value="consultations/{idC}", method = RequestMethod.GET)
	public Consultation findOne(@PathVariable("idC") Long idConsultation) {
		return consultationService.findOne(idConsultation);
	}
	
	//findBy (idOrdonnance)
	@RequestMapping(value="ordonnances/consultations/{idO}", method = RequestMethod.GET)
	public List<Consultation> findByIdOrdonnance(@PathVariable("idO") Long idOrdonnance) {
		return consultationService.findByIdOrdonnance(idOrdonnance);
	}
	
	//sauvegarder
	/*
	@RequestMapping(value = "consultation", method = RequestMethod.POST)
	public Consultation saveConsultation(@RequestBody Consultation consultation) {
		return consultationService.save(consultation);
	}
	*/
	
	//supprimer
	@RequestMapping(value = "consultations/{idConsultation}", method = RequestMethod.DELETE)
	public void deleteConsultation(@PathVariable("idConsultation") Long idConsultation) {
		consultationService.delete(idConsultation);
	}
	
	//verification de la sauvegarde
	@RequestMapping(value = "consultations", method=RequestMethod.POST)
	public String saveConsultation (
			@RequestParam(name = "idConsultation", required=true) Long idConsultation, 
			@RequestParam(name = "idPatient",required = true) Long idPatient,
			@RequestParam(name = "idMedecin",required = true) Long idMedecin,
			@RequestParam(name = "motifConsultation",required = false) String motifConsultation,
			@RequestParam(name = "date",required = true) Date date){
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
}
	//mettre à jour une consultation
    @RequestMapping(value="consultations/{idc}", method=RequestMethod.PUT)
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
