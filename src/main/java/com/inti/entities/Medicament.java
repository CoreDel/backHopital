package com.inti.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Medicament {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMedicament;
	private String nomMedicament;
	private String descMedicament;
	private Long quantMedicament;
	
	// constructeur vide
	public Medicament() {
		
	}
	
	// constructeur avec les attributs de base
	public Medicament(String nomMedicament, String descMedicament, Long quantMedicament) {
		this.nomMedicament = nomMedicament;
		this.descMedicament = descMedicament;
		this.quantMedicament = quantMedicament;
	}
	
	// getters et setters
	
	public Long getIdMedicament() {
		return idMedicament;
	}

	public void setIdMedicament(Long idMedicament) {
		this.idMedicament = idMedicament;
	}

	public String getNomMedicament() {
		return nomMedicament;
	}

	public void setNomMedicament(String nomMedicament) {
		this.nomMedicament = nomMedicament;
	}

	public String getDescMedicament() {
		return descMedicament;
	}

	public void setDescMedicament(String descMedicament) {
		this.descMedicament = descMedicament;
	}

	public Long getQuantMedicament() {
		return quantMedicament;
	}

	public void setQuantMedicament(Long quantMedicament) {
		this.quantMedicament = quantMedicament;
	}
	
	// toString

	@Override
	public String toString() {
		return "Medicament [idMedicament=" + idMedicament + ", nomMedicament=" + nomMedicament + ", descMedicament="
				+ descMedicament + ", quantMedicament=" + quantMedicament + "]";
	}
	
}
