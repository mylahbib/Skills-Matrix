package com.ensah.entity;

import java.util.Date;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ADD")
public class AddCompetence extends Operation {

	public AddCompetence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AddCompetence(Date dateOperation, int note, User user) {
		super(dateOperation, note, user);
		// TODO Auto-generated constructor stub
	}
	

}
