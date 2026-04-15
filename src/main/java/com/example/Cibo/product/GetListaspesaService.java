package com.example.Cibo.product;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.Cibo.model.Listaspesa;
import com.example.Cibo.model.ListaspesaDTO;
import com.example.Cibo.model.ListaspesaRepository;

@Service
public class GetListaspesaService implements Command<Void,List<ListaspesaDTO>>{
	
	private ListaspesaRepository listaspesaRepository;
	
	public GetListaspesaService(ListaspesaRepository listaspesaRepository) {
		this.listaspesaRepository = listaspesaRepository;
	}

	@Override
	public ResponseEntity<List<ListaspesaDTO>> execute(Void input) {
		List<Listaspesa> lista = listaspesaRepository.findAll();
		List<ListaspesaDTO> listaDTO = lista.stream().map(ListaspesaDTO::new).toList();
		return ResponseEntity.ok().body(listaDTO);
	}

}
