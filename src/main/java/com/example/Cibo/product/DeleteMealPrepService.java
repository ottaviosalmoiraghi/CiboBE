package com.example.Cibo.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Cibo.model.RicettaRepository;

@Service
public class DeleteMealPrepService implements Query<Void,String>{
	
	private RicettaRepository ricettaRepository;
	
	public DeleteMealPrepService(RicettaRepository ricettaRepository) {
		this.ricettaRepository = ricettaRepository;
	}

	@Override
	public ResponseEntity<String> execute(Void input){
		
		ricettaRepository.deletePrepMeal();
		return ResponseEntity.status(HttpStatus.OK).body("Meal Prep Cancellata");
	}

}
