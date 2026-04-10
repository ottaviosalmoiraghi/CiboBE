package com.example.Cibo.model;

import java.util.List;

import lombok.Data;

@Data
public class RicettaDTO {

	private int progRicetta;
	private String nome;
	private int numeroIngredienti;
	private String portata;
	private List<IngredienteDTO> ingredienti;
	private List<MealprepDTO> mealprep;

	public RicettaDTO(Ricetta ricetta) {

		this.progRicetta = ricetta.getProgRicetta();
		this.nome = ricetta.getNomeRicetta();
		this.numeroIngredienti = ricetta.getNumIngredienti();
		this.portata = ricetta.getPortata();
		this.ingredienti = ricetta.getIngredienti() == null ? List.of()
				: ricetta.getIngredienti().stream().map(IngredienteDTO::new).toList();
		this.mealprep = ricetta.getMealprep() == null ? List.of()
				: ricetta.getMealprep().stream().map(MealprepDTO::new).toList();

	}

	public int getProgRicetta() {
		return progRicetta;
	}

	public void setProgRicetta(int progRicetta) {
		this.progRicetta = progRicetta;
	}

	public List<IngredienteDTO> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(List<IngredienteDTO> ingredienti) {
		this.ingredienti = ingredienti;
	}

	public List<MealprepDTO> getMealprep() {
		return mealprep;
	}

	public void setMealprep(List<MealprepDTO> mealprep) {
		this.mealprep = mealprep;
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
