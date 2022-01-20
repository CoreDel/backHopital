package com.inti.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("dMedical")
public class DossierMedical extends Utilisateur implements Serializable {
	private Long numeroSecu;
	private String antecedent;
	private String traitement;
	private String operation;
	
	public DossierMedical() {
		super();
	}

	public DossierMedical(String nomUtilisateur, String prenomUtilisateur, Long age, 
			Long numeroSecu, String antecedent, String traitement, String operation) {
		super(nomUtilisateur, prenomUtilisateur, age);
		this.numeroSecu = numeroSecu;
		this.antecedent = antecedent;
		this.traitement = traitement;
		this.operation = operation;
	}

	public Long getNumeroSecu() {
		return numeroSecu;
	}

	public void setNumeroSecu(Long numeroSecu) {
		this.numeroSecu = numeroSecu;
	}

	public String getAntecedent() {
		return antecedent;
	}

	public void setAntecedent(String antecedent) {
		this.antecedent = antecedent;
	}

	public String getTraitement() {
		return traitement;
	}

	public void setTraitement(String traitement) {
		this.traitement = traitement;
	}

	public String getOperation() {
		return operation;
	}

	public void setOperation(String operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "DossierMedical [numeroSecu=" + numeroSecu + ", antecedent=" + antecedent + ", traitement=" + traitement
				+ ", operation=" + operation + "]";
	}
	
}
