package com.example.Cibo.model;

import java.util.List;

import lombok.Data;

@Data
public class RicettaDTO {
	
	private String nome;
	private int numeroIngredienti;
	private String portata;
	private List<IngredienteDTO> ingredienti;
	
	public RicettaDTO(Ricetta ricetta) {
		
		this.nome=ricetta.getNomeRicetta();
		this.numeroIngredienti=ricetta.getNumIngredienti();
		this.portata=ricetta.getPortata();
		this.ingredienti=ricetta.getIngredienti()
								.stream()
								.map(IngredienteDTO::new)
								.toList();
		
	}



	public List<IngredienteDTO> getIngredienti() {
		return ingredienti;
	}



	public void setIngredienti(List<IngredienteDTO> ingredienti) {
		this.ingredienti = ingredienti;
	}



	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getNumeroIngredienti() {
		return numeroIngredienti;
	}

	public void setNumeroIngredienti(int numeroIngredienti) {
		this.numeroIngredienti = numeroIngredienti;
	}

	public String getPortata() {
		return portata;
	}

	public void setPortata(String portata) {
		this.portata = portata;
	}

}
