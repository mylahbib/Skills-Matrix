package com.ensah.dao;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.ensah.entity.Competence;
import com.ensah.entity.User;

public interface  CompetenceDao  extends JpaRepository<Competence,Long>{
	@Query("select c from Competence c where c.id=:x")
	public Competence findCompetenceById(@Param("x")Long id);
	@Query("select c from Competence c where c.type=:x and c.niveau >= :y")
	public List<Competence> findCompetencesbyNiveau(@Param("x")String type,@Param("y") int niveau_min);
	
}
