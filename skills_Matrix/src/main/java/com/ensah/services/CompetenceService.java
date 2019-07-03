package com.ensah.services;

import java.util.List;

import com.ensah.entity.Competence;
import com.ensah.entity.User;

/**
 * @author Youssef Ait My Lahbib & Mohamed Mounaqid
 *
 */
public interface CompetenceService {
	
//	ajouter une competence 
	public void addCompetence(Competence c) ;
	
//	supprimer une competence 
	public void deleteCompetence(Long id) ;
	
// 	recuperer tout les competences 
	public List<Competence> getAllCompetences() ;
	
// 	chercher a une competence
	public Competence getCompetence(Long id);

//	modifier une competence
	 public void updatCompetence( Long id , Competence c) ;

//	 afficher les competences par utilisateur
	 public List<Competence> getCompetenceByUser(Long idu);
	 
//	Afficher les competences et les utilisateurs qui on un niveau de maturité dans cette competence
	 public List<Competence> getCompetenceswithusers(String type,int niveau_min);
}
