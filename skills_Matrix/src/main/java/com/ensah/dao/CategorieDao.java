package com.ensah.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ensah.entity.Categorie;

public interface CategorieDao  extends JpaRepository<Categorie, Long> {

	@Query("select c from Categorie c where c.id=:x")
	public Categorie findCategorieById(@Param("x")Long id);
}
