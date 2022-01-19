package com.inti.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Chambre implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idChambre;
	@Column(unique = true)
	private Long numChambre;
	@ManyToOne
	@JoinColumn(name = "id_hopital")
	private Hopital hopital;

	private Boolean dispoChambre;

	public Chambre() {

	}

	public Chambre(Long numChambre, Boolean dispoChambre) {

		this.numChambre = numChambre;
		this.dispoChambre = dispoChambre;
	}

	public Chambre(Long numChambre) {

		this.numChambre = numChambre;
	}

	public Long getIdChambre() {
		return idChambre;
	}

	public void setIdChambre(Long idChambre) {
		this.idChambre = idChambre;
	}

	public Long getNumChambre() {
		return numChambre;
	}

	public void setNumChambre(Long numChambre) {
		this.numChambre = numChambre;
	}

	public Hopital getHopital() {
		return hopital;
	}

	public void setHopital(Hopital hopital) {
		this.hopital = hopital;
	}

	public Boolean getDispoChambre() {
		return dispoChambre;
	}

	public void setDispoChambre(Boolean dispoChambre) {
		this.dispoChambre = dispoChambre;
	}

	@Override
	public String toString() {
		return "Chambre [idChambre=" + idChambre + ", numChambre=" + numChambre + ", hopital=" + hopital
				+ ", dispoChambre=" + dispoChambre + "]";
	}

}
