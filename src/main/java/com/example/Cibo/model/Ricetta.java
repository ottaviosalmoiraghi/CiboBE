package com.example.Cibo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "RICETTA")
public class Ricetta {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROG_RICETTA")
	private int progRicetta;
	
	@Column(name = "NOME_RICETTA")
	private String nomeRicetta;
	
	@Column(name = "NUM_INGREDIENTI")
	private int numIngredienti;
	
	@Column(name = "PORTATA")
	private String portata;
	
	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name="ID_RICETTA")
	private List<Ingrediente> ingredienti;
	
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

	@Column(name = "PASTO")
	private String pasto;
	
	@Column(name = "GIORNO")
	private String giorno;

	public String getPortata() {
		return portata;
	}

	public void setPortata(String portata) {
		this.portata = portata;
	}

	public List<Ingrediente> getIngredienti() {
		return ingredienti;
	}

	public void setIngredienti(List<Ingrediente> ingredienti) {
		this.ingredienti = ingredienti;
	}

	public int getProgRicetta() {
		return progRicetta;
	}

	public void setProgRicetta(int progRicetta) {
		this.progRicetta = progRicetta;
	}

	public String getNomeRicetta() {
		return nomeRicetta;
	}

	public void setNomeRicetta(String nomeRicetta) {
		this.nomeRicetta = nomeRicetta;
	}

	public int getNumIngredienti() {
		return numIngredienti;
	}

	public void setNumIngredienti(int numIngredienti) {
		this.numIngredienti = numIngredienti;
	}

	public Ricetta() {
	}
	

}
