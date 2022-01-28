package com.inti.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Consultation;
import com.inti.entities.Medicament;
import com.inti.repositories.ConsultationRepository;
import com.inti.service.interfaces.IConsultationService;

@Service
public class ConsultationService implements IConsultationService {

	@Autowired
	ConsultationRepository consultationRepository;

	@Override
	public List<Consultation> findAll() {

		return consultationRepository.findAll();
	}

	@Override
	public Consultation findOne(Long idConsultation) {	
		return consultationRepository.findById(idConsultation).get();
	}

	@Override
	public Consultation save(Consultation consultation) {
		
		return consultationRepository.save(consultation);
	}

	@Override
	public void delete(Long idConsultation) {
		consultationRepository.deleteById(idConsultation);
	}

	@Override
	public List<Consultation> findByDate(Date date) {
		return consultationRepository.findByDate(date);
	}

	@Override
	public List<Consultation> findByIdOrdonnance(Long idOrdonnance) {
		return consultationRepository.showConsultationById(idOrdonnance);
	}

	@Override
	public List<Consultation> showConsultationByUsernamePatient(String username) {
		return consultationRepository.showConsultationByUsernamePatient(username);
	}
}
