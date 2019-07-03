package com.ensah.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.dao.CategorieDao;
import com.ensah.entity.Categorie;
import com.ensah.services.CategorieService;
@Service
public class CategorieServiceImpl  implements CategorieService{
	@Autowired
	private CategorieDao categorieDao; 
	@Override
	public void addCategorie(Categorie c) {
		// TODO Auto-generated method stub
		categorieDao.save(c);
	}

	@Override
	public Categorie getCategorie(Long id) {
		// TODO Auto-generated method stub
		return categorieDao.findCategorieById(id);
	}

	@Override
	public void deleteCategorie(Long id) {
		// TODO Auto-generated method stub
		categorieDao.deleteById(id); 
	}

	@Override
	public List<Categorie> getAllCategorie() {
		// TODO Auto-generated method stub
		return categorieDao.findAll();
	}

	@Override
	public void updateCategorie(Long id, Categorie categorie) {
		// TODO Auto-generated method stub
		categorie.setId_cat(id);
		categorieDao.save(categorie);
		
	}
	

}
