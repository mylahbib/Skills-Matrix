package com.ensah.entity;

public class HistoriqueType {

	private String type;
	private int ans;
	private double niveau;

	public HistoriqueType(String type, int ans, double niveau) {
		super();
		this.type = type;
		this.ans = ans;
		this.niveau = niveau;
	}

	public HistoriqueType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getAns() {
		return ans;
	}

	public void setAns(int ans) {
		this.ans = ans;
	}

	public double getNiveau() {
		return niveau;
	}

	public void setNiveau(double niveau) {
		this.niveau = niveau;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Competence : "+this.type+" ans : "+this.ans+" niveau : "+this.niveau;
	}
}
