package com.ensah.entity;

import java.io.Serializable;
import java.util.List;

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
public class Categorie implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_cat;
	@NotNull
	@Size(min=4,max=50)
	private String nom;
	
	@OneToMany(mappedBy = "categorie", fetch = FetchType.LAZY)
	public List<Competence> competences;

	public Categorie(String nom) {
		super();
		this.nom = nom;
	}
	

	public void setId_cat(Long id_cat) {
		this.id_cat = id_cat;
	}


	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getNom() {
		return nom;
	}
	

	public void setNom(String nom) {
		this.nom = nom;
	}

	
	public Long getId_cat() {
		return id_cat;
	}

	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "********* id : "+id_cat+" nom : "+nom;
	}

	public Categorie(Long id_cat) {
		super();
		this.id_cat = id_cat;
	}
	
}
