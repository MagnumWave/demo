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

import com.softtek.labelling.demo.domain.Modal;
import com.softtek.labelling.demo.service.ModalService;

@RestController
@RequestMapping("/modais")
public class ModalController {
	@Autowired
	ModalService service;
	
	@GetMapping()
	List<Modal> getAll(){
		return service.obterTodos();
	}
	
	@GetMapping("/{id}")
	public Modal get(@PathVariable("id") Long id){
		return service.obter(id);
	}
	
	@PostMapping()
	public void post(@RequestBody Modal modal) {
		service.inserir(modal);
	}
	
	@PutMapping("/{id}")
	public void put(@PathVariable("id") Long id, @RequestBody Modal modal) {
		modal.setId(id);
		service.atualizar(modal);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable("id") Long id) {
		service.remover(id);
	}

}
