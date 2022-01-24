package com.inti.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import com.inti.model.Adresse;

@Entity
public class Hopital implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHopital;
	private String nomHopital;
	private Long numTelHopital;
	@Embedded
	private Adresse adresse;
	@OneToMany(mappedBy = "hopital")
	@Transient
	private Set<Chambre> chambres = new HashSet<>();
	
	@OneToMany(mappedBy = "hopitalU")
	@Transient
	private Set<Utilisateur> utilisateurs=new HashSet<>();

	public Hopital() {

	}

	public Hopital(String nomHopital, Long numTelHopital, Adresse adresse) {

		this.nomHopital = nomHopital;
		this.numTelHopital = numTelHopital;
		this.adresse = adresse;
	}

	public Hopital(String nomHopital, Long numTelHopital, Adresse adresse, Set<Chambre> chambres) {

		this.nomHopital = nomHopital;
		this.numTelHopital = numTelHopital;
		this.adresse = adresse;
		this.chambres = chambres;
	}

	public Long getIdHopital() {
		return idHopital;
	}

	public void setIdHopital(Long idHopital) {
		this.idHopital = idHopital;
	}

	public String getNomHopital() {
		return nomHopital;
	}

	public void setNomHopital(String nomHopital) {
		this.nomHopital = nomHopital;
	}

	public Long getNumTelHopital() {
		return numTelHopital;
	}

	public void setNumTelHopital(Long numTelHopital) {
		this.numTelHopital = numTelHopital;
	}

	public Adresse getAdresse() {
		return adresse;
	}

	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	public Set<Chambre> getChambres() {
		return chambres;
	}

	public void setChambres(Set<Chambre> chambres) {
		this.chambres = chambres;
	}

	public Set<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}

	public void setUtilisateurs(Set<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}

	@Override
	public String toString() {
		return "Hopital [idHopital=" + idHopital + ", nomHopital=" + nomHopital + ", numTelHopital=" + numTelHopital
				+ ", adresse=" + adresse + ", chambres=" + chambres + ", utilisateurs=" + utilisateurs + "]";
	}

	

}
