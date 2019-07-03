package com.ensah.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("UPD")
public class UpdateCompetence extends Operation  {

	public UpdateCompetence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UpdateCompetence(Date dateOperation, int note, User user) {
		super(dateOperation, note, user);
		// TODO Auto-generated constructor stub
	}
		
}
