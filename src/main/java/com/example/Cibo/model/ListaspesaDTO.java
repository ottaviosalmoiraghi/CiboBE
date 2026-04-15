package com.example.Cibo.model;

import lombok.Data;

@Data
public class ListaspesaDTO {
	
	private int id;
	private String elementoLista;

	public ListaspesaDTO(Listaspesa listaspesa) {
		this.elementoLista = listaspesa.getElementoLista();
		this.id=listaspesa.getIdElementoLista();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getElementoLista() {
		return elementoLista;
	}

	public void setElementoLista(String elementoLista) {
		this.elementoLista = elementoLista;
	}

}
