package com.softtek.labelling.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.labelling.demo.domain.Placa;
import com.softtek.labelling.demo.handler.CustomException;
import com.softtek.labelling.demo.service.PlacaService;

@RestController
@RequestMapping("/placas")
public class PlacaController {
	@Autowired
	PlacaService service;
	
	@GetMapping()
	public List<Placa> getAll() throws Exception{
		return service.obterTodos();
	}
	
	@GetMapping("/{id}")
	public Placa get(@PathVariable("id") Long id) throws CustomException{
		return service.obter(id);
	}
	
	@PostMapping()
	public void post(@Valid @RequestBody Placa placa) throws CustomException {
//		throw new SQLException();
		service.inserir(placa);
	}
	
	@PutMapping("/{id}")
	public void put(@PathVariable("id") Long id, @Valid @RequestBody Placa placa) throws CustomException {
		placa.setId(id);
		service.atualizar(placa);
		 
		
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) throws CustomException {
		service.remover(id);
	}

}
