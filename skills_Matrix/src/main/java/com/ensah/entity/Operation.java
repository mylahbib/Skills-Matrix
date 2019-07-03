package com.ensah.entity;

import java.util.Calendar;
import java.util.Date;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="TYPE_OP",discriminatorType=DiscriminatorType.STRING,length=3)
public abstract class Operation {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long numOperation;
	private Date dateOperation;
	private Long id_competence;
	private int note;
	@ManyToOne
	@JoinColumn(name = "id_user")
	private User user;

	public Operation() {
		super();
	}

	public Operation(Date dateOperation, int note, User user) {
		super();
		this.dateOperation = dateOperation;
		this.note = note;
		this.user = user;
	}

	public Long getNumOperation() {
		return numOperation;
	}

	public void setNumOperation(Long numOperation) {
		this.numOperation = numOperation;
	}

	public Date getDateOperation() {
		return dateOperation;
	}

	public void setDateOperation(Date dateOperation) {
		this.dateOperation = dateOperation;
	}

	public int getNote() {
		return note;
	}

	public void setNote(int note) {
		this.note = note;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getId_competence() {
		return id_competence;
	}

	public void setId_competence(Long id_competence) {
		this.id_competence = id_competence;
	}
	@Override
	public String toString() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.dateOperation);
		int year = cal.get(Calendar.YEAR);
		return this.getClass().getSimpleName()+"| ID comp : "+ this.id_competence+" | Note : "+this.note+" | Num opertaion : "+this.numOperation+" | Date : "+year;
	}

}
