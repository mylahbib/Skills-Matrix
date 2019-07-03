package com.ensah.services;

import java.util.List;

import com.ensah.entity.Competence;
import com.ensah.entity.Operation;

public interface OperationService {

	public void mettre_a_jour(Long id_user,Long id_competence,int niveau);
	public void add_competence(Long id_user,Competence co,int niveau);
	public List<Operation> listOperations();
}
