package com.ensah.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.dao.CompetenceDao;
import com.ensah.dao.UserDao;
import com.ensah.entity.Competence;
import com.ensah.entity.User;
import com.ensah.services.CompetenceService;
import com.ensah.services.UserService;

@Service
public class ComptenceServiceImpl implements CompetenceService {

	@Autowired
	private CompetenceDao competenceDao;
	
	@Autowired
	private UserDao userDao;

	@Override
	public void addCompetence(Competence c) {
		// TODO Auto-generated method stub
		competenceDao.save(c);

	}

	@Override
	public void deleteCompetence(Long id) {
		// TODO Auto-generated method stub
		competenceDao.deleteById(id);
	}

	@Override
	public List<Competence> getAllCompetences() {
		// TODO Auto-generated method stub

		return competenceDao.findAll();
	}

	@Override
	public Competence getCompetence(Long id) {
		// TODO Auto-generated method stub
		return competenceDao.findCompetenceById(id);
	}

	@Override
	public void updatCompetence(Long id, Competence c) {
		// TODO Auto-generated method stub

		c.setId_comp(id);
		competenceDao.save(c);
	}

	//Retourne la liste des competence d'un utilisateur
	@Override
	public List<Competence> getCompetenceByUser(Long id) {
		List<Competence> competences=competenceDao.findAll();
		List<Competence> competenceofuser= new ArrayList<>();
		for(int i=0;i<competences.size();i++)
		{
			if(competences.get(i).getUser().getId()==id)
				{competenceofuser.add(competences.get(i));
				}
				
		}
		return competenceofuser;
	}

	
	@Override
	public List<Competence> getCompetenceswithusers(String type, int niveau_min) {
		// TODO Auto-generated method stub
		return competenceDao.findCompetencesbyNiveau(type, niveau_min);
	}
	
	

}
