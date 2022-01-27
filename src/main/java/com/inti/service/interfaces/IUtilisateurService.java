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
	
	// affiche users en fonction du role(libelle)
	List<Utilisateur> findByRole(String libelle);
	
	//nombre de users en fonction du role(libelle) 
	Integer nbUserByRole(String libelle);
	
	// update user+role
	void majUtilisateurAndRole(String nomUtilisateur, String prenomUtilisateur, Long age, String password, Long idRole, Long idUtilisateur);

	//save user+role
	void saveUtilisateurAndRolesaveUtilisateurAndRole(String dossierMedical, String nomUtilisateur, String prenomUtilisateur, Long age, String username, String password, Long idRole);

}
