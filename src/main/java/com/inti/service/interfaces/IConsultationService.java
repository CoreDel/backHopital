package com.inti.service.interfaces;

import java.util.Date;
import java.util.List;

import com.inti.entities.Consultation;

public interface IConsultationService {
	
	List<Consultation> findAll();
	
	Consultation findOne(Long idConsultation);
	
	Consultation save(Consultation consultation);
	
	void delete(Long idConsultation);
	
	List<Consultation> findByDate(Date date);
	
	List<Consultation> findByIdOrdonnance(Long idOrdonnance);
	
	List<Consultation> showConsultationByUsernamePatient(String username);
}
