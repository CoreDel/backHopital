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

	@Override
	public Long checkQuantityById(Long id) {
		Medicament med = null;
		med = medicamentRepository.findById(id).get();
		return med.getQuantMedicament();
	}

	@Override
	public Long checkQuantityByName(String name) {
		return medicamentRepository.checkQuantityByName(name);
	}

}
