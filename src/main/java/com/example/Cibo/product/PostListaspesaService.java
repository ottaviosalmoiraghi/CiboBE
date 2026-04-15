package com.example.Cibo.product;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Cibo.model.Listaspesa;
import com.example.Cibo.model.ListaspesaDTO;
import com.example.Cibo.model.ListaspesaRepository;

@Service
public class PostListaspesaService implements Query<List<Listaspesa>, List<ListaspesaDTO>> {

	private ListaspesaRepository listaspesaRepository;

	public PostListaspesaService(ListaspesaRepository listaspesaRepository) {
		this.listaspesaRepository = listaspesaRepository;
	}

	@Override
	public ResponseEntity<List<ListaspesaDTO>> execute(List<Listaspesa> lista) {
		listaspesaRepository.saveAll(lista);
		List<ListaspesaDTO> listaDTO = lista.stream().map(ListaspesaDTO::new).toList();
		return ResponseEntity.status(HttpStatus.OK).body(listaDTO);
	}

}
