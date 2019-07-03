package com.ensah.services;

import java.util.List;

import com.ensah.entity.Categorie;

/**
 * @author Youssef Ait My Lahbib & Mohamed Mounaqid
 *
 */
public interface CategorieService {

	// ajouter une categorie
	public void addCategorie(Categorie u);

	// chercher a une categorie
	public Categorie getCategorie(Long id);

	// supprimer categorie
	public void deleteCategorie(Long id);

	// recuperer tout les categories
	public List<Categorie> getAllCategorie();

	// modifier une categorie
	public void updateCategorie(Long id, Categorie categorie);

}
