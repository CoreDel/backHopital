package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Hopital;
import com.inti.service.interfaces.IHopitalService;

@RestController
@CrossOrigin
public class HopitalController {
	@Autowired
	IHopitalService hopitalService;

	@GetMapping("/hopital")
	public List<Hopital> findAll() {
		return hopitalService.findAll();
	}

	@RequestMapping(value = "hopital/{idH}", method = RequestMethod.GET)
	public Hopital findOne(@PathVariable("idH") Long idHopital) {
		return hopitalService.findOne(idHopital);
	}

	@PostMapping("/hopital")
	public Hopital saveHopital(@RequestBody Hopital hopital) {
		return hopitalService.save(hopital);
	}

	@PutMapping("/utilisateurs/{idU}")
	public Hopital updateHopital(@PathVariable("idH") Long idHopital, @RequestBody Hopital hopital) {
		Hopital currentHopital = hopitalService.findOne(idHopital);
		currentHopital.setNomHopital(hopital.getNomHopital());
		currentHopital.setNumTelHopital(hopital.getNumTelHopital());
		currentHopital.setAdresse(hopital.getAdresse());
		return hopitalService.save(currentHopital);
	}

	@DeleteMapping("/hopital/ {idH]")
	public void deleteHopital(@PathVariable("idHopital") Long idHopital) {
		hopitalService.delete(idHopital);
	}
}
