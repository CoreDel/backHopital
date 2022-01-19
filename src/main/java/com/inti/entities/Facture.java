package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.inti.entities.Ordonnance;

@Entity
public class Facture implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFacture;
	private Long prix;
	private String type;
	private String description;
	
	@OneToOne
	private Ordonnance ordonnance;
	
	public Facture() {
		
	}

	public Facture(Long prix, String type, String description) {
		this.prix = prix;
		this.type = type;
		this.description = description;
	}

	public Facture(Long prix, String type, String description, Ordonnance ordonnance) {
		this.prix = prix;
		this.type = type;
		this.description = description;
		this.ordonnance = ordonnance;
	}

	public Long getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}

	public Long getPrix() {
		return prix;
	}

	public void setPrix(Long prix) {
		this.prix = prix;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Ordonnance getOrdonnance() {
		return ordonnance;
	}

	public void setOrdonnance(Ordonnance ordonnance) {
		this.ordonnance = ordonnance;
	}

	@Override
	public String toString() {
		return "Facture [idFacture=" + idFacture + ", prix=" + prix + ", type=" + type + ", description=" + description
				+ "]";
	}
	
	
	
}
