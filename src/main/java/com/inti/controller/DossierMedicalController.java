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
	
	//mettre à jour un dossierMedical
    @RequestMapping(value="dossiermedical/{iddm}", method=RequestMethod.PUT)
    public DossierMedical updateDossierMedical(@PathVariable("iddm") Long numeroSecu,
            @RequestBody DossierMedical dossierMedical) {
        DossierMedical currentDossier = dossierMedicalService.findOne(numeroSecu);
        if(dossierMedical.getNumeroSecu() != 0)  {                             
        currentDossier.setNumeroSecu(dossierMedical.getNumeroSecu());
        }
        if(dossierMedical.getAntecedent() != null)  {
        currentDossier.setAntecedent(dossierMedical.getAntecedent());
        }
        if(dossierMedical.getTraitement() != null)  {
        currentDossier.setTraitement(dossierMedical.getTraitement());
        }
        if(dossierMedical.getOperation() != null)  	{
        currentDossier.setOperation(dossierMedical.getOperation());
        }
        return dossierMedicalService.save(currentDossier);
    }
		
}
