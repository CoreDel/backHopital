package com.inti.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inti.entities.DossierMedical;

@Service
public interface IDossierMedicalService {
	List<DossierMedical> findAll();
	DossierMedical findOne(Long numeroSecu);
	DossierMedical save(DossierMedical dossierMedical);
	void delete(Long numeroSecu);
	DossierMedical findByNumeroSecu(Long numeroSecu);

}
