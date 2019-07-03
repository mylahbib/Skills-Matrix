package com.ensah.services.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ensah.dao.UserDao;
import com.ensah.entity.User;
import com.ensah.services.UserService;

@Service
public   class UserServiceImpl implements UserService{
	@Autowired
	private UserDao userDao;

	
//	chercher un utilisateur
	public User getUser( Long id ) {
		return userDao.findUserById(id);
	}

//	ajouter un utilisateur
	public void addUser(User u) {

		userDao.save(u);

	}
	
//	supprimer un utilisateur 
	public void deleteUser( Long id) {
		userDao.deleteById(id);

	}
//	recuperer tout les utilisateurs

	public List<User> getAllUsers() {
		

		return userDao.findAll();
		
	}
	
//	modifier un utilisateur 
	public void updateUser(Long id , User user) {
		//TODO vérifier cette methode
		
		user.setId_user(id);
		userDao.save(user);
		
	}

	@Override
	public   List<User> chercherUsers( String mc) {
		
			
		return userDao.chercher(mc);
	}
//	
	
	

}
