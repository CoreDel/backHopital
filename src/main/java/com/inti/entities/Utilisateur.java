package com.inti.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="dossier_medical", discriminatorType = DiscriminatorType.STRING)
public class Utilisateur implements Serializable{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long idUtilisateur;
	private String nomUtilisateur;
    private String prenomUtilisateur;
    @Column(unique = true)
    private String username;
    private String password;
    private Long age;
    private boolean enabled = true;
    
    //many to many role
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "Profil", joinColumns = @JoinColumn (name = "id_utilisateur", referencedColumnName = "idUtilisateur"), 
    inverseJoinColumns = @JoinColumn (name = "id_role", referencedColumnName ="idRole"))
    private Set<Role> roles = new HashSet<>();
    
    //one to many hopital
    @ManyToOne
    @JoinColumn(name = "idHopital")
    private Hopital hopitalU;
    
  
    
    public Utilisateur() {
	}
    //constructeur utilisé par la classe fille
    public Utilisateur(String nomUtilisateur, String prenomUtilisateur, Long age) {
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.age = age;
	}
    
	public Utilisateur(String nomUtilisateur, String prenomUtilisateur, String username, String password, Long age) {
		this.nomUtilisateur = nomUtilisateur;
		this.prenomUtilisateur = prenomUtilisateur;
		this.username = username;
		this.password = password;
		this.age = age;
	}

	public Long getIdUtilisateur() {
		return idUtilisateur;
	}

	public void setIdUtilisateur(Long idUtilisateur) {
		this.idUtilisateur = idUtilisateur;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
	}

	public String getPrenomUtilisateur() {
		return prenomUtilisateur;
	}

	public void setPrenomUtilisateur(String prenomUtilisateur) {
		this.prenomUtilisateur = prenomUtilisateur;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getAge() {
		return age;
	}

	public void setAge(Long age) {
		this.age = age;
	}
	
	public Set<Role> getRoles() {
		return roles;
	}
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}
	
	public Hopital getHopitalU() {
		return hopitalU;
	}
	public void setHopitalU(Hopital hopitalU) {
		this.hopitalU = hopitalU;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	@Override
	public String toString() {
		return "Utilisateur [idUtilisateur=" + idUtilisateur + ", nomUtilisateur=" + nomUtilisateur
				+ ", prenomUtilisateur=" + prenomUtilisateur + ", username=" + username + ", password=" + password
				+ ", age=" + age + ", enabled=" + enabled + ", roles=" + roles + ", hopitalU=" + hopitalU + "]";
	}
	
}
