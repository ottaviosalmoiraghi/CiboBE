package com.example.Cibo.model;

import lombok.Data;

@Data
public class MealprepDTO {
	
	private int id;
	private String giorno;
	private String pasto;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getGiorno() {
		return giorno;
	}
	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}
	public String getPasto() {
		return pasto;
	}
	public void setPasto(String pasto) {
		this.pasto = pasto;
	}
	
	public MealprepDTO(Mealprep mealprep) {
		this.id = mealprep.getIdMeal();
		this.giorno = mealprep.getGiorno();
		this.pasto = mealprep.getPasto();
	}
	
	

}
