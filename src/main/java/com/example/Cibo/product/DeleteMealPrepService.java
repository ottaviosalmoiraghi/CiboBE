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
public class DeleteMealPrepService implements Query<Void,List<RicettaDTO>>{
	
	private final RicettaRepository ricettaRepository;

	public DeleteMealPrepService(RicettaRepository ricettaRepository) {
		this.ricettaRepository = ricettaRepository;
	}

	@Override
	@Transactional
	public ResponseEntity<List<RicettaDTO>> execute(Void input){
		
		List<Ricetta> ricetteCancellate = ricettaRepository.findRicetteByWeek();
		List<RicettaDTO> ricetteCancellateDTO = ricetteCancellate.stream().map(RicettaDTO::new).toList();
		ricetteCancellate.forEach(r -> r.getMealprep().clear());
		return ResponseEntity.status(HttpStatus.OK).body(ricetteCancellateDTO);
	}

}
