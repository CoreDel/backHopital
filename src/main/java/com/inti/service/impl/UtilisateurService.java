package com.inti.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inti.entities.Utilisateur;
import com.inti.repositories.UtilisateurRepository;
import com.inti.service.interfaces.IUtilisateurService;

@Service
public class UtilisateurService implements IUtilisateurService {
	
	@Autowired
	UtilisateurRepository utilisateurRepository;

	@Override
	public List<Utilisateur> findAll() {
		// TODO Auto-generated method stub
		return utilisateurRepository.findAll();
	}

	@Override
	public Utilisateur findOne(Long idUtilisateur) {
		// TODO Auto-generated method stub
		return utilisateurRepository.findById(idUtilisateur).get();
	}

	@Override
	public Utilisateur save(Utilisateur utilisateur) {
		// TODO Auto-generated method stub
		return utilisateurRepository.save(utilisateur);
	}

	@Override
	public void delete(Long idUtilisateur) {
		// TODO Auto-generated method stub
		utilisateurRepository.deleteById(idUtilisateur);
	}

	@Override
	public Utilisateur findByUsername(String username) {
		return utilisateurRepository.findByUsername(username);
	}

	@Override
	public Utilisateur findByNomUtilisateurAndPrenomUtilisateur(String nomUtilisateur, String prenomUtilisateur) {
		return utilisateurRepository.findByNomUtilisateurAndPrenomUtilisateur(nomUtilisateur, prenomUtilisateur);
	}

	@Override
	public List<Utilisateur> findByRole(String libelle) {
		return utilisateurRepository.showUserByRole(libelle);
	}

	@Override
	public Integer nbUserByRole(String libelle) {
		return utilisateurRepository.nbUserByRole(libelle);
	}

	@Override
	public Utilisateur majUtilisateurAndRole(String nomUtilisateur, String prenomUtilisateur, Long age, String password,
			Long idRole, Long idUtilisateur) {
		return utilisateurRepository.majUtilisateurAndRole(nomUtilisateur, prenomUtilisateur, age, password, idRole, idUtilisateur);
	}


}
