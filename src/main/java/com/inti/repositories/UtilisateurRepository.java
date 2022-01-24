package com.inti.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.entities.Utilisateur;

@Repository
public interface UtilisateurRepository extends JpaRepository<Utilisateur, Long>{
	Utilisateur findByUsername(String username);
	Utilisateur findByNomUtilisateur(String nomUtilisateur);
	
	@Query(value = "SELECT * FROM utilisateur WHERE id_utilisateur IN (SELECT id_utilisateur FROM profil WHERE id_role IN (SELECT id_role FROM role WHERE libelle =?1 ))",
			nativeQuery = true)
	List<Utilisateur> showUserByRole(String Role);
	
		
		
}
