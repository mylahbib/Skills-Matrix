package com.ensah.services;

import java.util.List;

import com.ensah.entity.HistoriqueType;
import com.ensah.entity.Operation;

public interface HistoriqueService {

	//Fonction qui retourne le niveau actuel d'une competence dans l'entreprise
	public double niveauActuelByCompetence(String cmp);
	//Fonction qui affiche l'historique durant les années precedente 
	public List<HistoriqueType> historiqueComp(String cmp);
	//Fonction qui affiche l'evolution d'un collaborateur dans une technologie
	public List<HistoriqueType> historiqueCompByuser(String cmp,Long id);
}
