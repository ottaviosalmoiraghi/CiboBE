package com.example.Cibo.product;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Cibo.model.Ricetta;
import com.example.Cibo.model.RicettaRepository;

@Service
public class UpdateMealPrepService implements Query<List<Ricetta>, String> {

	private RicettaRepository ricettaRepository;

	public UpdateMealPrepService(RicettaRepository ricettaRepository) {
		this.ricettaRepository = ricettaRepository;
	}

	@Override
	public ResponseEntity<String> execute(List<Ricetta> ricette) {

		ricette.forEach(ricetta -> ricettaRepository.updatePrepMealById(ricetta.getGiorno(),
				ricetta.getPasto(), ricetta.getProgRicetta()));
		return ResponseEntity.status(HttpStatus.OK).body("Meal Prep Aggiornato!");

	}

}
