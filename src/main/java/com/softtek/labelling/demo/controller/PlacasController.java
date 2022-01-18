package com.softtek.labelling.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.softtek.labelling.demo.domain.Placas;
import com.softtek.labelling.demo.service.PlacasService;

@RestController
@RequestMapping("/placas")
public class PlacasController {
	@Autowired
	PlacasService service;
	
	@GetMapping()
	List<Placas> getAll(){
		return service.obterTodos();
	}
	
	@GetMapping("/{id}")
	public Placas get(@PathVariable("id") Long id){
		return service.obter(id);
	}
	
	@PostMapping()
	public void post(@RequestBody Placas placa) {
		service.inserir(placa);
	}
	
	@PutMapping("/{id}")
	public void put(@PathVariable("id") Long id, @RequestBody Placas placa) {
		placa.setId(id);
		service.atualizar(placa);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.remover(id);
	}

}
