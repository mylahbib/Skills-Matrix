package com.ensah.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ensah.entity.User;

/**
 * @author Youssef Ait My Lahbib & Mohamed Mounaqid 
 *
 *
 */
@Service
public interface UserService {
	public User getUser( Long id ) ;

//	ajouter un utilisateur
	public void addUser(User u);
	
//	supprimer un utilisateur 
	public void deleteUser( Long id) ;
//	recuperer tout les utilisateurs

	public List<User> getAllUsers() ;
	
//	modifier un utilisateur 
	public void updateUser(Long id , User user);

	public List<User> chercherUsers(String  mc) ;

}
