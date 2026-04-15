package com.example.Cibo.product;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Cibo.model.Ingrediente;
import com.example.Cibo.model.IngredienteDTO;
import com.example.Cibo.model.Ricetta;
import com.example.Cibo.model.RicettaRepository;

@Service
public class GetListaIngredientiService implements Query<Void, List<IngredienteDTO>> {

	private RicettaRepository ricettaRepository;

	public GetListaIngredientiService(RicettaRepository ricettaRepository) {
		this.ricettaRepository = ricettaRepository;
	}

	@Override
	public ResponseEntity<List<IngredienteDTO>> execute(Void input) {

		List<Ricetta> ricette = ricettaRepository.findRicetteByWeek();
		List<Ingrediente> listaIngredienti = new ArrayList<>();
		for (Ricetta r : ricette) {
			List<Ingrediente> ingredienti = r.getIngredienti();
			for (Ingrediente i : ingredienti) {
				boolean check = true;
				for (Ingrediente l : listaIngredienti) {
					if (l.getIngrediente().equals(i.getIngrediente())) {
						check = false;
						if ("UOVA".equals(l.getIngrediente()))
							l.setQuantita4(l.getQuantita4() + i.getQuantita4());
					}
				}
				if (check)
					listaIngredienti.add(i);
			}
		}
		List<IngredienteDTO> listaIngredientiDTO = listaIngredienti.stream().map(IngredienteDTO::new).toList();
		return ResponseEntity.status(HttpStatus.OK).body(listaIngredientiDTO);

	}

}
