package com.ensah.services.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.dao.OperationDao;
import com.ensah.entity.AddCompetence;
import com.ensah.entity.Categorie;
import com.ensah.entity.Competence;
import com.ensah.entity.Operation;
import com.ensah.entity.UpdateCompetence;
import com.ensah.entity.User;
import com.ensah.services.CompetenceService;
import com.ensah.services.OperationService;
import com.ensah.services.UserService;
@Service
public class OperationServiceImpl implements OperationService{

	@Autowired
	public OperationDao operationDao;
	@Autowired
	public UserService userService;
	@Autowired
	public CompetenceService competenceService;
	@Transactional
	@Override
	public void mettre_a_jour(Long id_user, Long id_competence,int niveau) {
		Competence co=competenceService.getCompetence(id_competence);
		co.setNiveau(niveau);
		User user=userService.getUser(id_user);
		Operation op=new UpdateCompetence(new Date(), niveau, user);
		op.setId_competence(id_competence);
		operationDao.save(op); 
	} 

	@Override
	public void add_competence(Long id_user,Competence com,int niveau) {
		boolean existe=false;
		List<Competence> competences=competenceService.getCompetenceByUser(id_user);
		for(int i=0;i<competences.size();i++)
		{
			System.out.println(competences.get(i));
			if(competences.get(i).getType().equals(com.getType()))
				{
				System.out.println("La competence existe déja");
				existe=true;
				break;
				
				}
		}
		if(existe==false)
		{
		com.setNiveau(niveau);
		User user=userService.getUser(id_user);
		com.setUser(user);
		
		
		competenceService.addCompetence(com);
		Operation op=new AddCompetence(new Date(), niveau, user);
		op.setId_competence(com.getId_comp());
		operationDao.save(op); 
		}
	}


	@Override
	public List<Operation> listOperations() {
		
		return operationDao.findAll();
	}

}
