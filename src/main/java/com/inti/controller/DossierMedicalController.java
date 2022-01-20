package com.inti.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.DossierMedical;
import com.inti.service.interfaces.IDossierMedicalService;

@RestController
@CrossOrigin
public class DossierMedicalController {
	
	@Autowired
	IDossierMedicalService dossierMedicalService;

	//find all
	@RequestMapping(value = "dossiermedical", method = RequestMethod.GET)
	public List<DossierMedical> findAll(){
		return dossierMedicalService.findAll();
	}
	
	//find one
	@RequestMapping(value="dossiermedical/{iddm}", method = RequestMethod.GET)
	public DossierMedical findOne(@PathVariable("iddm") Long numeroSecu) {
		return dossierMedicalService.findOne(numeroSecu);
	}
	
	//sauvegarde du dossier medical
	@RequestMapping(value = "dossiermedical", method = RequestMethod.POST)
	public DossierMedical saveDossierMedical(@RequestBody DossierMedical dossierMedical) {
		return dossierMedicalService.save(dossierMedical);
	}
	
	//suppression d'un dossier medical
	@RequestMapping(value = "dossiermedical/{numeroSecu}", method = RequestMethod.DELETE)
	public void deleteDossierMedical(@PathVariable("numeroSecu") Long numeroSecu) {
		dossierMedicalService.delete(numeroSecu);
	}
	
	//verification de la sauvegarde
	@RequestMapping(value = "dossiermedical", method=RequestMethod.POST)
	public String saveDossierMedical (@RequestParam(name = "numeroSecu", required=true) Long numeroSecu, @RequestParam(name = "antecedent",required = false) String antecedent,
			@RequestParam(name = "traitement",required = false) String traitement,@RequestParam(name = "operation",required = false) String operations) {
	try {
		DossierMedical currentUser = new DossierMedical(); 
		currentUser.setNumeroSecu(numeroSecu);
		currentUser.setAntecedent(antecedent);
		currentUser.setTraitement(traitement);
		currentUser.setOperation(operations);
		dossierMedicalService.save(currentUser);
		return "Dossier ajouté avec succée";
    }
	catch(Exception ex) {
        ex.printStackTrace();
        return "Le dossier n'a pas pu être ajouté";
	}
}
	//mettre à jour un dossierMedical
    @RequestMapping(value="dossiermedical/{iddm}", method=RequestMethod.PUT)
    public DossierMedical updateDossierMedical(@PathVariable("iddm") Long numeroSecu,
            @RequestBody DossierMedical dossierMedical) {
        DossierMedical currentDossier = dossierMedicalService.findOne(numeroSecu);
                                                                                
        currentDossier.setNumeroSecu(dossierMedical.getNumeroSecu());
        currentDossier.setAntecedent(dossierMedical.getAntecedent());
        currentDossier.setTraitement(dossierMedical.getTraitement());
        currentDossier.setOperation(dossierMedical.getOperation());
        return dossierMedicalService.save(currentDossier);
    }
		
}
