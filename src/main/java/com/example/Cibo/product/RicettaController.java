package com.example.Cibo.product;
import org.springframework.web.bind.annotation.RestController;

import com.example.Cibo.model.Ricetta;
import com.example.Cibo.model.RicettaDTO;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class RicettaController {
	

	private final GetProductsService getProductsService;
	
	private final PostProductService postProductService;
	
	private final GetProductService getProductService;
	
	private final GetRicettaByPortataService getRicettaByPortataService;
	


	public RicettaController(GetProductsService getProductsService, PostProductService postProductService,
			GetProductService getProductService, GetRicettaByPortataService getRicettaByPortataService) {
		this.getProductsService = getProductsService;
		this.postProductService = postProductService;
		this.getProductService = getProductService;
		this.getRicettaByPortataService = getRicettaByPortataService;
	}

	@GetMapping("/read")
	public ResponseEntity<List<RicettaDTO>> getProduct() {
		
		return getProductsService.execute(null);
		
	}
	
	@GetMapping("/readId/{id}")
	public ResponseEntity<RicettaDTO> getProductById(@PathVariable("id") Integer id){
		 
		return getProductService.execute(id);
		
	}
	
	@GetMapping("/portata/{nomePortata}")
	ResponseEntity<List<RicettaDTO>> getRicettaByPortata(@PathVariable("nomePortata") String nomePortata){
		
		return getRicettaByPortataService.execute(nomePortata);
		
	}
	
	@PostMapping("/insert")
	public ResponseEntity<RicettaDTO> postProduct(@RequestBody Ricetta ricetta) {
		
		return postProductService.execute(ricetta);
		
	}

}
