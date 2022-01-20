package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.DossierMedical;
import com.inti.repositories.DossierMedicalRepository;

import com.inti.service.interfaces.IDossierMedicalService;

@Service
public class DossierMedicalService implements IDossierMedicalService{

	@Autowired
	DossierMedicalRepository dossierMedicalRepository;
	
	@Override
	public List<DossierMedical> findAll() {
		
		return dossierMedicalRepository.findAll();
	}

	@Override
	public DossierMedical findOne(Long idDossierMedical) {
		
		return dossierMedicalRepository.findById(idDossierMedical).get();
	}

	@Override
	public void delete(Long idDossierMedical) {
		dossierMedicalRepository.deleteById(idDossierMedical);
		
	}

	@Override
	public DossierMedical findByNumeroSecu(Long numeroSecu) {
		// TODO Auto-generated method stub
		return dossierMedicalRepository.findByNumeroSecu(numeroSecu);
	}

	@Override
	public DossierMedical save(DossierMedical dossierMedical) {
		// TODO Auto-generated method stub
		return dossierMedicalRepository.save(dossierMedical);
	}

}
