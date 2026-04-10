package com.example.Cibo.product;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Cibo.model.Ricetta;
import com.example.Cibo.model.RicettaDTO;
import com.example.Cibo.model.RicettaRepository;

import jakarta.transaction.Transactional;

@Service
public class UpdateMealPrepService implements Query<List<Ricetta>, List<RicettaDTO>> {

	private RicettaRepository ricettaRepository;

	public UpdateMealPrepService(RicettaRepository ricettaRepository) {
		this.ricettaRepository = ricettaRepository;
	}

	@Override
	@Transactional
	public ResponseEntity<List<RicettaDTO>> execute(List<Ricetta> ricette) {

		List<RicettaDTO> ricetteDTO = ricette.stream().map(RicettaDTO::new).toList();
		ricette.forEach(this::aggiornaMealprep);
		return ResponseEntity.status(HttpStatus.OK).body(ricetteDTO);

	}
	
	private void aggiornaMealprep(Ricetta ricetta) {
		
		Ricetta db = ricettaRepository.findById(ricetta.getProgRicetta()).orElse(null);
		
		if(db == null) {
			ricettaRepository.save(ricetta);
			return;
		}
		
//		db.getMealprep().clear();
		db.getMealprep().addAll(ricetta.getMealprep());
		
	}

}
