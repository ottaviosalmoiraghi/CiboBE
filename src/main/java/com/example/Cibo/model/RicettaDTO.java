package com.example.Cibo.model;

import java.util.List;

import lombok.Data;

@Data
public class RicettaDTO {
	
	private int progRicetta;
	private String nome;
	private int numeroIngredienti;
	private String portata;
	private String giorno;
	private String pasto;
	private List<IngredienteDTO> ingredienti;
	
	public RicettaDTO(Ricetta ricetta) {
		
		this.progRicetta=ricetta.getProgRicetta();
		this.nome=ricetta.getNomeRicetta();
		this.numeroIngredienti=ricetta.getNumIngredienti();
		this.portata=ricetta.getPortata();
		this.pasto=ricetta.getPasto();
		this.giorno=ricetta.getGiorno();
		this.ingredienti=ricetta.getIngredienti()
								.stream()
								.map(IngredienteDTO::new)
								.toList();
		
	}



	public int getProgRicetta() {
		return progRicetta;
	}



	public void setProgRicetta(int progRicetta) {
		this.progRicetta = progRicetta;
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
