package com.softtek.labelling.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.labelling.demo.domain.Placa;
import com.softtek.labelling.demo.service.PlacaService;

@RestController
@RequestMapping("/placas")
public class PlacaController {
	@Autowired
	PlacaService service;
	
	@GetMapping()
	List<Placa> getAll(){
		return service.obterTodos();
	}
	
	@GetMapping("/{id}")
	public Placa get(@PathVariable("id") Long id){
		return service.obter(id);
	}
	
	@PostMapping()
	public ResponseEntity<Placa> post(@Valid @RequestBody Placa placa) {
//		if (placa.getAltura()==null ||
//			placa.getCodigoSap()==null ||
//			placa.getEspessura()==null ||
//			placa.getLargura()==null ||
//			placa.getPeso()==null) {
//			//retorna invalido
//			return new ResponseEntity<Placa>(HttpStatus.BAD_REQUEST);
//			
//		} else {
//			service.inserir(placa);
//			return new ResponseEntity<Placa>(HttpStatus.OK);
//		}
		
		return ResponseEntity.ok(null);
	}
	
	@PutMapping("/{id}")
	public void put(@PathVariable("id") Long id, @RequestBody Placa placa) {
		placa.setId(id);
		service.atualizar(placa);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.remover(id);
	}

}
