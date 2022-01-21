package com.inti.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

@Entity
public class Consultation {
	
	/** Variables **/
	// "idConsultation" est la clef primaire autogénérée de la table "Consultation"
	@Id // Clef primaire
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Id est autogénéré
	private long idConsultation;
	private long idPatient;
	private long idMedecin;
	private String motifConsultation;
	private Date date;
	
	/** Associations **/
	// Association avec l'entité ordonnance
	@OneToOne(mappedBy="consultation")
	@Transient
	private Ordonnance ordonnance;	
	
	/** Constructeurs **/
	public Consultation() {
	
	}

	public Consultation(long idPatient, long idMedecin, String motifConsultation, Date date) {
		this.idPatient = idPatient;
		this.idMedecin = idMedecin;
		this.motifConsultation = motifConsultation;
		this.date = date;
	}
	
	/** Getters & Setters **/
	public long getIdConsultation() {
		return idConsultation;
	}
	public void setIdConsultation(long idConsultation) {
		this.idConsultation = idConsultation;
	}
	public long getIdPatient() {
		return idPatient;
	}
	public void setIdPatient(long idPatient) {
		this.idPatient = idPatient;
	}
	public long getIdMedecin() {
		return idMedecin;
	}
	public void setIdMedecin(long idMedecin) {
		this.idMedecin = idMedecin;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Ordonnance getOrdonnance() {
		return ordonnance;
	}

	public void setOrdonnance(Ordonnance ordonnance) {
		this.ordonnance = ordonnance;
	}

	
	public String getMotifConsultation() {
		return motifConsultation;
	}

	public void setMotifConsultation(String motifConsultation) {
		this.motifConsultation = motifConsultation;
	}
	
	/** Methodes **/
	@Override
	public String toString() {
		return "Consultation [idConsultation=" + idConsultation + ", idPatient=" + idPatient + ", idMedecin="
				+ idMedecin + ", motifConsultation=" + motifConsultation + ", date=" + date + "]";
	}
}
