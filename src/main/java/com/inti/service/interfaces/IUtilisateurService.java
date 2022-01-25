package com.inti.service.interfaces;

import java.util.List;

import org.springframework.stereotype.Service;

import com.inti.entities.Utilisateur;
@Service
public interface IUtilisateurService {
	List<Utilisateur> findAll();
	Utilisateur findOne (Long idUtilisateur);
	Utilisateur save(Utilisateur utilisateur);
	void delete(Long idUtilisateur);
	
	Utilisateur findByUsername(String username);
	
	Utilisateur findByNomUtilisateurAndPrenomUtilisateur(String nomUtilisateur, String prenomUtilisateur);
	
	List<Utilisateur> findByRole(String libelle);
	Integer nbUserByRole(String libelle);
}
