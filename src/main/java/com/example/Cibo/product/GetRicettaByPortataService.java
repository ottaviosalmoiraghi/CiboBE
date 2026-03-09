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
public class GetRicettaByPortataService implements Query<String, List<RicettaDTO>>{
	
	private final RicettaRepository ricettaRepository;
	
	public GetRicettaByPortataService(RicettaRepository ricettaRepository) {
		this.ricettaRepository = ricettaRepository;
	}

	public ResponseEntity<List<RicettaDTO>> execute(String portata){
		
		List<Ricetta> listaRicette = ricettaRepository.findRicettaByPortata(portata);
		listaRicette.sort(Comparator.comparing(Ricetta::getNomeRicetta));
		List<RicettaDTO> listaFinale = listaRicette.stream().map(RicettaDTO::new).toList();
		return ResponseEntity.status(HttpStatus.OK).body(listaFinale);
		
	}

}
