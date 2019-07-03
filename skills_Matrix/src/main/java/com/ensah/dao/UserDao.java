package com.ensah.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ensah.entity.User;

public interface UserDao extends JpaRepository<User, Long>{

	@Query("select u from User u where u.id=:x ")
	public User findUserById(@Param("x")Long id);
	
	@Query("select u from User u where u.nom like :x or u.prenom like :x")
	public List<User> chercher(@Param("x") String mc ) ;
}
