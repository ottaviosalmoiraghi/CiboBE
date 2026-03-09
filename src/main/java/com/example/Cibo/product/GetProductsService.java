package com.example.Cibo.product;

import java.util.Comparator;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Cibo.model.Ricetta;
import com.example.Cibo.model.RicettaDTO;
import com.example.Cibo.model.RicettaRepository;

@Service
public class GetProductsService implements Query<Void, List<RicettaDTO>> {
	
	private final RicettaRepository ricettaRepository;
	
	public GetProductsService(RicettaRepository ricettaRepository) {
		this.ricettaRepository = ricettaRepository;
	}



	@Override
	public ResponseEntity<List<RicettaDTO>> execute(Void input){
		
		List<Ricetta> ricette = ricettaRepository.findAll();
		ricette.sort(Comparator.comparing(Ricetta::getNomeRicetta));
		List<RicettaDTO> ricettaDTO = ricette.stream().map(RicettaDTO::new).toList();
		return ResponseEntity.status(HttpStatus.OK).body(ricettaDTO);
		
	}

}
