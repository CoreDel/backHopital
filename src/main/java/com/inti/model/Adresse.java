package com.inti.model;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Embeddable;

@Embeddable
public class Adresse implements Serializable{
	private String rue;
	private String codePostal;
	public Adresse() {
	
	}
	public Adresse(String rue, String codePostal) {
		this.rue = rue;
		this.codePostal = codePostal;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	@Override
	public int hashCode() {
		return Objects.hash(codePostal, rue);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Adresse other = (Adresse) obj;
		return Objects.equals(codePostal, other.codePostal) && Objects.equals(rue, other.rue);
	}
	@Override
	public String toString() {
		return "Adresse [rue=" + rue + ", codePostal=" + codePostal + "]";
	}
	

}