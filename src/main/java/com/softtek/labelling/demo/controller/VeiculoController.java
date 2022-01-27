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

import com.softtek.labelling.demo.domain.Veiculo;
import com.softtek.labelling.demo.service.VeiculoService;

@RestController
@RequestMapping("/veiculos")
public class VeiculoController {
	@Autowired
	VeiculoService service;
	
	@GetMapping()
	List<Veiculo> getAll(){
		return service.obterTodos();
	}
	
	@GetMapping("/{id}")
	public Veiculo get(@PathVariable("id") Long id){
		return service.obter(id);
	}
	
	@PostMapping()
	public void post(@RequestBody Veiculo veiculo) {
		service.inserir(veiculo);
	}
	
	@PutMapping("/{id}")
	public void put(@PathVariable("id") Long id, @RequestBody Veiculo veiculo) {
		veiculo.setId(id);
		service.atualizar(veiculo);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.remover(id);
	}

}
