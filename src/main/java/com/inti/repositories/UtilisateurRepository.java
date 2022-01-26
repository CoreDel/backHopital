package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	Utilisateur findByUsername(String username);
	
	Utilisateur findByNomUtilisateurAndPrenomUtilisateur(String nomUtilisateur, String prenomUtilisateur);
	
	// affiche users en fonction du role(libelle)
	@Query(value = "SELECT * FROM utilisateur WHERE id_utilisateur IN (SELECT id_utilisateur FROM profil WHERE id_role IN (SELECT id_role FROM role WHERE libelle =?1 ))",
			nativeQuery = true)
	List<Utilisateur> showUserByRole(String Role);
	
	//nombre de users en fonction du role(libelle) 
	@Query(value = "SELECT count(*) FROM utilisateur WHERE id_utilisateur IN (SELECT id_utilisateur FROM profil WHERE id_role IN (SELECT id_role FROM role WHERE libelle =?1 ))",
			nativeQuery = true)
	Integer nbUserByRole(String Role);
	
	// update user+role
	@Query(value = "UPDATE utilisateur u INNER JOIN profil p ON u.id_utilisateur=p.id_utilisateur "
			+ "SET u.nom_utilisateur = ?1, u.prenom_utilisateur = ?2, u.age = ?3, u.password = ?4, p.id_role = ?5"
			+ " WHERE u.id_utilisateur= ?6 ", nativeQuery = true)
	Utilisateur majUtilisateurAndRole(String nomUtilisateur, String prenomUtilisateur, Long age, String password, Long idRole, Long idUtilisateur);
		
		
}
