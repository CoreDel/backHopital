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
	@RequestMapping(value = "consultation", method = RequestMethod.GET)
	public List<Consultation> findAll(){
		return consultationService.findAll();
	}
	
	//find one
	@RequestMapping(value="consultation/{idc}", method = RequestMethod.GET)
	public Consultation findOne(@PathVariable("idc") Long idConsultation) {
		return consultationService.findOne(idConsultation);
	}
	
	//sauvegarder
	@RequestMapping(value = "consultation", method = RequestMethod.POST)
	public Consultation saveConsultation(@RequestBody Consultation consultation) {
		return consultationService.save(consultation);
	}
	
	//supprimer
	@RequestMapping(value = "consultation/{idConsultation}", method = RequestMethod.DELETE)
	public void deleteConsultation(@PathVariable("idConsultation") Long idConsultation) {
		consultationService.delete(idConsultation);
	}
	
	//verification de la sauvegarde
	@RequestMapping(value = "consultation", method=RequestMethod.POST)
	public String saveConsultation (
			@RequestParam(name = "idConsultation", required=true) Long idConsultation, 
			@RequestParam(name = "idPatient",required = true) Long idPatient,
			@RequestParam(name = "idMedecin",required = true) Long idMedecin,
			@RequestParam(name = "date",required = true) Date date){
	try {
		Consultation currentUser = new Consultation(); 
		currentUser.setIdConsultation(idConsultation);
		currentUser.setIdPatient(idPatient);
		currentUser.setIdMedecin(idMedecin);
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
    @RequestMapping(value="consultation/{idc}", method=RequestMethod.PUT)
    public Consultation updateDossierMedical(@PathVariable("idc") Long idConsultation,
            @RequestBody Consultation consultation) {
        Consultation currentConsultation = consultationService.findOne(idConsultation);                                                                              
        currentConsultation.setIdConsultation(consultation.getIdConsultation());
        currentConsultation.setIdPatient(consultation.getIdPatient());
        currentConsultation.setIdMedecin(consultation.getIdMedecin());
        currentConsultation.setDate(consultation.getDate());
        
        return consultationService.save(currentConsultation);
    }
	
}