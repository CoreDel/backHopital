package com.inti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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
    @RequestMapping(value="utilisateurs/{idU}/{username}", method =
    RequestMethod.GET)
    public Utilisateur findByIdUtilisateurAndUsername(@PathVariable("idU") Long idUtilisateur,
            @PathVariable("username") String username) {
        return utilisateurService.findByUsername(username);
    }
    
    //find by nom
    @RequestMapping(value="utilisateurs/{idU}/{nom}", method =
    RequestMethod.GET)
    public Utilisateur findByIdUtilisateurAndNom(@PathVariable("idU") Long idUtilisateur,
            @PathVariable("nom") String nomUtilisateur) {
        return utilisateurService.findByNom(nomUtilisateur);
    }
    
    //sauvegarder un utilisateur
    @RequestMapping(value="utilisateurs", method=RequestMethod.POST)
    public Utilisateur saveutilisateur(@RequestBody Utilisateur utilisateur) { 
    	return utilisateurService.save(utilisateur); 
      }
    
    //verification de la sauvegarde et début de mise en place d'un formulaire
    @RequestMapping(value="utilisateurs", method=RequestMethod.POST)
    public String saveUtilisateur(@RequestParam(name = "nomUtilisateur",required = true) String nomUtilisateur, @RequestParam(name="prenomUtilisateur",required = true) String prenomUtilisateur,
            @RequestParam(name="username",required = true) String username, @RequestParam(name="password",required = true) String password,
            @RequestParam(name="age", required = true) Long age) {
        try {
            Utilisateur currentUser=new Utilisateur();
            currentUser.setNomUtilisateur(nomUtilisateur);
            currentUser.setPrenomUtilisateur(prenomUtilisateur);
            currentUser.setUsername(username);
            currentUser.setPassword(password);
            currentUser.setAge(age);
            utilisateurService.save(currentUser);
            return "Utilisateur ajouté avec succée";
        }catch(Exception ex) {
            ex.printStackTrace();
            return "L'utilisateur n'a pas pu être ajouté";
        }
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
    
    //effacer un utilisateur
    @RequestMapping(value = "utilisateurs/{idUtilisateur}", method = RequestMethod.DELETE)
    public void deleteUtilisateur(@PathVariable("idUtilisateur") Long idUtilisateur) {
        utilisateurService.delete(idUtilisateur);
    }
}
