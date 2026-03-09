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
@Table(name="INGREDIENTE")
public class Ingrediente {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="PROG_INGREDIENTE")
	private int progIngrediente;
	
	@Column(name="NOME_INGREDIENTE")
	private String ingrediente;
	
	@Column(name="QUANTITA4")
	private int quantita4;

	public int getProgIngrediente() {
		return progIngrediente;
	}

	public void setProgIngrediente(int progIngrediente) {
		this.progIngrediente = progIngrediente;
	}

	public String getIngrediente() {
		return ingrediente;
	}

	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}

	public int getQuantita4() {
		return quantita4;
	}

	public void setQuantita4(int quantita4) {
		this.quantita4 = quantita4;
	}

	public Ingrediente() {
	}
	


}
