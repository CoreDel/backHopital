package com.inti.service.interfaces;

import java.util.List;

import com.inti.entities.Hopital;

public interface IHopitalService {
	
	List<Hopital> findAll();

	Hopital findOne(Long idHopital);

	Hopital save(Hopital hopital);

	void delete(Long idHopital);


}
