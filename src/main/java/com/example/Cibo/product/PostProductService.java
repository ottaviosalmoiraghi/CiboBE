package com.example.Cibo.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Cibo.model.Ricetta;
import com.example.Cibo.model.RicettaDTO;
import com.example.Cibo.model.RicettaRepository;

@Service
public class PostProductService implements Command<Ricetta,RicettaDTO>{

	private final RicettaRepository ricettaRepository;
	
	public PostProductService(RicettaRepository ricettaRepository) {
		this.ricettaRepository = ricettaRepository;
	}

	@Override
	public ResponseEntity<RicettaDTO> execute(Ricetta ricetta) {
		
		ricetta.setNomeRicetta(ricetta.getNomeRicetta().toUpperCase().trim());
		ricetta.getIngredienti().forEach(i -> i.setIngrediente(i.getIngrediente().toUpperCase().trim()));
		Ricetta savedRicetta = ricettaRepository.save(ricetta);
		return ResponseEntity.status(HttpStatus.CREATED).body(new RicettaDTO(savedRicetta));
		
	}
	
}
