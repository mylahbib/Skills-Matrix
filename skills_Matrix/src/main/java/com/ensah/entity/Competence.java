package com.ensah.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * @author Youssef Ait My Lahbib & Mohamed Mounaqid
 *  
 *
 */


@Entity
public class Competence implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id_comp ; 
	private String type ;
	@NotNull
	@Min(0)
	@Max(4)
	private   int niveau ;
	@ManyToOne
	@JoinColumn(name="ID_CATEGORIE")
	private Categorie categorie ;
	@ManyToOne
	@JoinColumn(name="id_USER")
	private User user ; 
	
	
	
	
	public Competence(String type, Categorie categorie) {
		super();
		this.type = type;
		this.categorie=categorie;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getNiveau() {
		return niveau;
	}
	public void setNiveau(int niveau) {
		this.niveau = niveau;
	}
	public Competence(String type, int niveau) {
		super();
		this.type = type;
		this.niveau = niveau;
	}
	public Competence() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	public Long getId_comp() {
		return id_comp;
	}
	public void setId_comp(Long id_comp) {
		this.id_comp = id_comp;
	}
	public Categorie getCategorie() {
		return categorie;
	}
	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "********** Id : "+id_comp+" Competence : "+type+" Niveau : "+niveau;
	}
	public Competence(String type, int niveau, Categorie categorie, User user) {
		super();
		this.type = type;
		this.niveau = niveau;
		this.categorie = categorie;
		this.user = user;
	}
	
	

}
