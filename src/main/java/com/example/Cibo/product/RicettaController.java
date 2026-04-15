package com.example.Cibo.product;

import org.springframework.web.bind.annotation.RestController;

import com.example.Cibo.model.IngredienteDTO;
import com.example.Cibo.model.Listaspesa;
import com.example.Cibo.model.ListaspesaDTO;
import com.example.Cibo.model.Ricetta;
import com.example.Cibo.model.RicettaDTO;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import org.springframework.http.HttpStatus;
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
	private final DeleteMealPrepService deleteMealPrepService;
	private final UpdateMealPrepService updateMealPrepService;
	private final GetWeekService getWeekService;
	private final GetListaIngredientiService getListaIngredientiService;
	private final PostListaspesaService postListaspesaService;
	private final DeleteListaspesaService deleteListaspesaService;
	private final GetListaspesaService getListaspesaService;

	public RicettaController(GetProductsService getProductsService, PostProductService postProductService,
			GetListaspesaService getListaspesaService, PostListaspesaService postListaspesaService,
			DeleteListaspesaService deleteListaspesaService, GetProductService getProductService,
			GetRicettaByPortataService getRicettaByPortataService, DeleteMealPrepService deleteMealPrepService,
			UpdateMealPrepService updateMealPrepService, GetWeekService getWeekService,
			GetListaIngredientiService getListaIngredientiService) {
		this.getProductsService = getProductsService;
		this.postProductService = postProductService;
		this.getProductService = getProductService;
		this.getRicettaByPortataService = getRicettaByPortataService;
		this.deleteMealPrepService = deleteMealPrepService;
		this.updateMealPrepService = updateMealPrepService;
		this.getWeekService = getWeekService;
		this.getListaIngredientiService = getListaIngredientiService;
		this.postListaspesaService = postListaspesaService;
		this.deleteListaspesaService = deleteListaspesaService;
		this.getListaspesaService = getListaspesaService;
	}

	@GetMapping("/read")
	public ResponseEntity<List<RicettaDTO>> getProduct() {
		return getProductsService.execute(null);
	}

	@GetMapping("/readId/{id}")
	public ResponseEntity<RicettaDTO> getProductById(@PathVariable("id") Integer id) {
		return getProductService.execute(id);
	}

	@GetMapping("/portata/{nomePortata}")
	ResponseEntity<List<RicettaDTO>> getRicettaByPortata(@PathVariable("nomePortata") String nomePortata) {
		return getRicettaByPortataService.execute(nomePortata);
	}

	@PostMapping("/insert")
	public ResponseEntity<RicettaDTO> postProduct(@RequestBody Ricetta ricetta) {
		return postProductService.execute(ricetta);
	}

	@GetMapping("/ready")
	public ResponseEntity<String> getReady() {
		return ResponseEntity.status(HttpStatus.OK).body("Tutto ok");
	}

	@PostMapping("/deleteMealPrep")
	public ResponseEntity<List<RicettaDTO>> deleteMealPrep() {
		return deleteMealPrepService.execute(null);
	}

	@PostMapping("/updateMealPrep")
	public ResponseEntity<List<RicettaDTO>> updateMealPrep(@RequestBody List<Ricetta> ricette) {
		return updateMealPrepService.execute(ricette);
	}

	@GetMapping("/readWeek")
	public ResponseEntity<List<RicettaDTO>> getWeek() {
		return getWeekService.execute(null);
	}

	@GetMapping("/getIngredienti")
	public ResponseEntity<List<IngredienteDTO>> getListaIngredienti() {
		return getListaIngredientiService.execute(null);
	}

	@PostMapping("/salvaLista")
	public ResponseEntity<List<ListaspesaDTO>> postListaspesa(@RequestBody List<Listaspesa> lista) {
		return postListaspesaService.execute(lista);
	}
	
	@GetMapping("/readLista")
	public ResponseEntity<List<ListaspesaDTO>> getListaspesa() {
		return getListaspesaService.execute(null);
	}
	
	@PostMapping("/deleteLista")
	public ResponseEntity<List<ListaspesaDTO>> deleteListaspesa() {
		return deleteListaspesaService.execute(null);
	}

}
