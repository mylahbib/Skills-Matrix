package com.ensah.entity;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Youssef Ait My Lahbib & Mohamed Mounaqid
 *
 */
@Entity
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_user;
	@NotNull
	@Size(min=4,max=20)
	private String nom;
	@NotNull
	@Size(min=4,max=20)
	private String prenom;
	@NotNull
	private int password;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	private Collection<Competence> competences;

	@OneToMany(mappedBy="user")
	private Collection<Operation> operations;
	
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public Long getId() {
		return id_user;
	}

	public User(String nom, String prenom, int i) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.password = i;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getId_user() {
		return id_user;
	}

	public void setId_user(Long id_user) {
		this.id_user = id_user;
	}

	public Collection<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(Collection<Competence> competences) {
		this.competences = competences;
	}
	
	
	
	public Collection<Operation> getOperations() {
		return operations;
	}

	public void setOperations(Collection<Operation> operations) {
		this.operations = operations;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "* Id : "+id_user+" * Nom : "+nom+" * Prenom: "+prenom+" * Password : "+password;
	}

	public User(Long id_user) {
		super();
		this.id_user = id_user;
	}

	
	
}
