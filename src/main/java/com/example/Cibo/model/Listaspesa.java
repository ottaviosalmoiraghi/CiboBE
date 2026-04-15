package com.example.Cibo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "listaspesa")
@Data
public class Listaspesa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int idElementoLista;

	@Column(name = "elementolista")
	private String elementoLista;

	public int getIdElementoLista() {
		return idElementoLista;
	}

	public void setIdElementoLista(int idElementoLista) {
		this.idElementoLista = idElementoLista;
	}

	public String getElementoLista() {
		return elementoLista;
	}

	public void setElementoLista(String elementoLista) {
		this.elementoLista = elementoLista;
	}

	public Listaspesa() {
	}

}
