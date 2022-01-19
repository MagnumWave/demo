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

import com.softtek.labelling.demo.domain.Despacho;
import com.softtek.labelling.demo.dto.EnvioDespachoDTO;
import com.softtek.labelling.demo.service.DespachoService;

@RestController
@RequestMapping("/despachos")
public class DespachoController {
	@Autowired
	DespachoService service;
	
	@GetMapping()
	List<Despacho> getAll(){
		return service.obterTodos();
	}
	
	@GetMapping("/{id}")
	public Despacho get(@PathVariable("id") Long id){
		return service.obter(id);
	}
	
	@PostMapping()
	public void post(@RequestBody Despacho despacho) {
		service.inserir(despacho);
	}
	
	@PutMapping("/{id}")
	public void put(@PathVariable("id") Long id, @RequestBody Despacho despacho) {
		despacho.setId(id);
		service.atualizar(despacho);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.remover(id);
	}
	
	@PostMapping("/envio")
	public void envioDespacho(@RequestBody EnvioDespachoDTO envio) {
		service.enviar(envio);
	}

}
