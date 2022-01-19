package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Medicament;
import com.inti.repositories.MedicamentRepository;
import com.inti.service.interfaces.IMedicamentService;

@Service
public class MedicamentService implements IMedicamentService {

	@Autowired
	MedicamentRepository medicamentRepository;

	@Override
	public List<Medicament> findAll() {
		return medicamentRepository.findAll();
	}

	@Override
	public Medicament save(Medicament medicament) {
		return medicamentRepository.save(medicament);
	}

	@Override
	public void delete(Long idMedicament) {
		medicamentRepository.deleteById(idMedicament);

	}

	@Override
	public Medicament findOneById(Long id) {
		return medicamentRepository.findById(id).get();
	}

}
