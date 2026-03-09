package com.example.Cibo.product;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Cibo.model.Ricetta;
import com.example.Cibo.model.RicettaDTO;
import com.example.Cibo.model.RicettaRepository;

@Service
public class GetProductService implements Query<Integer, RicettaDTO>{
	
	private final RicettaRepository ricettaRepository;
	
	public GetProductService(RicettaRepository ricettaRepository) {
		this.ricettaRepository = ricettaRepository;
	}

	@Override
	public ResponseEntity<RicettaDTO> execute(Integer id) {
		
		Optional<Ricetta> ricetta = ricettaRepository.findById(id);
		
		if(ricetta.isPresent()) {
			return ResponseEntity.ok(new RicettaDTO(ricetta.get()));
		}
		
		return null;
		
	}

}
