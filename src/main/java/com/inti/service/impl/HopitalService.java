package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Hopital;
import com.inti.repositories.HopitalRepository;
import com.inti.service.interfaces.IHopitalService;

@Service
public class HopitalService implements IHopitalService{

	@Autowired
	HopitalRepository hopitalRepository;
	
	@Override
	public List<Hopital> findAll() {
		
		return hopitalRepository.findAll();
	}

	@Override
	public Hopital findOne(Long idHopital) {
		
		return hopitalRepository.findById(idHopital).get();
	}

	@Override
	public Hopital save(Hopital hopital) {
		
		return hopitalRepository.save(hopital);
	}

	@Override
	public void delete(Long idHopital) {
		hopitalRepository.deleteById(idHopital);
		
	}


}
