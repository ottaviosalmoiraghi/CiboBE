package com.example.Cibo.model;

import lombok.Data;

@Data
public class IngredienteDTO {
	
	private String ingrediente;
	private int quantita;
	
	public IngredienteDTO (Ingrediente ingrediente) {
		
		this.ingrediente=ingrediente.getIngrediente();
		this.quantita=ingrediente.getQuantita4();
		
	}
	
	public String getIngrediente() {
		return ingrediente;
	}
	public void setIngrediente(String ingrediente) {
		this.ingrediente = ingrediente;
	}
	public int getQuantita() {
		return quantita;
	}
	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}
	
	

}
