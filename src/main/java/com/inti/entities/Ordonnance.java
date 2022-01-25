package com.inti.entities;

import java.io.Serializable;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Ordonnance implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idOrdonnance;
	private String soinPrescrit;
	// Relation OneToOne avec facture
	@OneToOne(mappedBy = "ordonnance")
	@Transient
	private Facture facture;
	@OneToOne
	@JoinColumn(name="id_consultation")
	private Consultation consultation;
	// Relation ManyToMany avec medicament
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "ProfilOrd", joinColumns = @JoinColumn(name = "idOrd", referencedColumnName = "idOrdonnance"), inverseJoinColumns = @JoinColumn(name = "idMed", referencedColumnName = "idMedicament"))
	private Set<Medicament> medicamentPrescrit = new HashSet<Medicament>();
	
	// constructeur vide
	
	public Ordonnance() {
		
	}
	
	// constructeur avec les attributs de base

	public Ordonnance(String soinPrescrit) {
		this.soinPrescrit = soinPrescrit;
	}
	
	// constructeur avec les attributs de base et les cle etrangeres

	public Ordonnance(String soinPrescrit, Facture facture, Consultation consultation, Set<Medicament> medicamentPrescrit) {
		this.soinPrescrit = soinPrescrit;
		this.facture = facture;
		this.consultation = consultation;
		this.medicamentPrescrit = medicamentPrescrit;
	}
	
	// getters et setters

	public Long getIdOrdonnance() {
		return idOrdonnance;
	}

	public void setIdOrdonnance(Long idOrdonnance) {
		this.idOrdonnance = idOrdonnance;
	}

	public String getSoinPrescrit() {
		return soinPrescrit;
	}

	public void setSoinPrescrit(String soinPrescrit) {
		this.soinPrescrit = soinPrescrit;
	}

	public Facture getFacture() {
		return facture;
	}

	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	public Set<Medicament> getMedicamentPrescrit() {
		return medicamentPrescrit;
	}

	public void setMedicamentPrescrit(Set<Medicament> medicamentPrescrit) {
		this.medicamentPrescrit = medicamentPrescrit;
	}
	
	// toString

	public Consultation getConsultation() {
		return consultation;
	}

	public void setConsultation(Consultation consultation) {
		this.consultation = consultation;
	}

	@Override
	public String toString() {
		return "Ordonnance [idOrdonnance=" + idOrdonnance + ", soinPrescrit=" + soinPrescrit + ", facture=" + facture
				+ ", medicamentPrescrit=" + medicamentPrescrit + "]";
	}
	
}
