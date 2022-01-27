package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inti.entities.Utilisateur;
import com.inti.service.interfaces.IUtilisateurService;

@RestController
@CrossOrigin
public class UtilisateurController {
    @Autowired
    IUtilisateurService utilisateurService;
    
   @Autowired
   PasswordEncoder passwordEncoder;
    
    //find all
    @RequestMapping(value="utilisateurs", method = RequestMethod.GET)
    public List<Utilisateur> findAll() {
        return utilisateurService.findAll();
    }
    
    //find one
    @RequestMapping(value="utilisateurs/{idU}", method = RequestMethod.GET)
    public Utilisateur findOne(@PathVariable("idU") Long idUtilisateur) {
        return utilisateurService.findOne(idUtilisateur);
    }
    
    //find by username
    @RequestMapping(value="utilisateurs/username/{username}", method =
    RequestMethod.GET)
    public Utilisateur findByUsername(@PathVariable("username") String username) {
        return utilisateurService.findByUsername(username);
    }
    
    //find by nom et prenom
    @RequestMapping(value="utilisateurs/{nom}/{prenom}", method = RequestMethod.GET)
    public Utilisateur findByNomUtilisateurAndPrenomUtilisateur(@PathVariable("nom") String nomUtilisateur, @PathVariable("prenom") String prenomUtilisateur) {
        return utilisateurService.findByNomUtilisateurAndPrenomUtilisateur(nomUtilisateur, prenomUtilisateur);
    }
    
    //find by role
    @RequestMapping(value = "user/{libelle_role}", method = RequestMethod.GET)
    public List<Utilisateur> findByRole(@PathVariable("libelle_role") String libelle){
    	return utilisateurService.findByRole(libelle);
    }
    
    //sauvegarder un utilisateur
    @RequestMapping(value="utilisateurs", method=RequestMethod.POST)
    public Utilisateur saveutilisateur(@RequestBody Utilisateur utilisateur) {
    	Utilisateur currentUser=new Utilisateur(utilisateur.getNomUtilisateur(),utilisateur.getPrenomUtilisateur(),
				utilisateur.getUsername(),passwordEncoder.encode(utilisateur.getPassword()), utilisateur.getAge());
    	return utilisateurService.save(currentUser); 
      }
    

    //mettre à jour un utilisateur
    @RequestMapping(value="utilisateurs/{idU}", method=RequestMethod.PUT)
    public Utilisateur updateUtilisateur(@PathVariable("idU") Long idUtilisateur,
    		@RequestBody Utilisateur utilisateur) {
        Utilisateur currentUtilisateur = utilisateurService.findOne(idUtilisateur);
                                                                                
        currentUtilisateur.setNomUtilisateur(utilisateur.getNomUtilisateur());
        currentUtilisateur.setPrenomUtilisateur(utilisateur.getPrenomUtilisateur());
        currentUtilisateur.setUsername(utilisateur.getUsername());
        currentUtilisateur.setPassword(utilisateur.getPassword());
        currentUtilisateur.setAge(utilisateur.getAge());
        return utilisateurService.save(currentUtilisateur);
    }
    
    //maj utilisateur+role
//    @RequestMapping(value="utilisateurs/roles/{idU}", method=RequestMethod.PUT)
//    public Utilisateur majUtilisateurAndRole(@PathVariable("idU") Long idUtilisateur, @RequestParam(required = false) String prenom,
//    		@RequestParam(required = false) String nom,
//    		@RequestParam(required = false) Long age, 
//    		@RequestParam(required = false) String password, 
//    		@RequestParam(required = false) Long idRole) {
//    	Utilisateur currentUtilisateur = utilisateurService.findOne(idUtilisateur);
//    	currentUtilisateur.setPrenomUtilisateur(prenom);
//    	currentUtilisateur.setNomUtilisateur(nom);
//        currentUtilisateur.setPassword(password);
//        currentUtilisateur.setAge(age);
////            currentUtilisateur.setRoles(idRole)
//        
//    	return utilisateurService.save(currentUtilisateur);
//    }

   
    //effacer un utilisateur
    @RequestMapping(value = "utilisateurs/{idUtilisateur}", method = RequestMethod.DELETE)
    public void deleteUtilisateur(@PathVariable("idUtilisateur") Long idUtilisateur) {
        utilisateurService.delete(idUtilisateur);
    }
    
    //nombre d'utilisateur
    @RequestMapping(value = "nombreutilisateurs/{libelle_role}", method = RequestMethod.GET)
    public Integer nbUserByRole(@PathVariable("libelle_role") String libelle){
    	return utilisateurService.nbUserByRole(libelle);
    }
    
}
