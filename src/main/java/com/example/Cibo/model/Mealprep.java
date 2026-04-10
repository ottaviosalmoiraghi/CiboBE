package com.example.Cibo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "mealprep")
public class Mealprep {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_meal")
	private int idMeal;

	@Column(name = "pasto")
	private String pasto;

	@Column(name = "giorno")
	private String giorno;

	public int getIdMeal() {
		return idMeal;
	}

	public void setIdMeal(int idMeal) {
		this.idMeal = idMeal;
	}

	public String getPasto() {
		return pasto;
	}

	public void setPasto(String pasto) {
		this.pasto = pasto;
	}

	public String getGiorno() {
		return giorno;
	}

	public void setGiorno(String giorno) {
		this.giorno = giorno;
	}

	public Mealprep() {
	}

}
