package com.softtek.labelling.demo.controller;

import java.util.Optional;

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
import com.softtek.labelling.demo.service.ServicePaginated;

@RestController
@RequestMapping("/placas")
public class PlacaController extends PaginatedController<Placa,Long> {

	//antes esse controller não fazia extend do PaginatedController
	
	@Autowired
	PlacaService service;
	
	
	@Override
	public ServicePaginated<Placa, Long> getService() {
		// TODO Auto-generated method stub
		return service;
	}
	
	//o metodo acima tem que ser implementado por causa da herança da PaginatedController
	//o retorno é implementado pela ServicePaginated que usa a paginação.
	//ele retorna a placa service sendo tratada pela ServicePaginated 
	
	//os métodos abaixo são os restantes clássicos de CRUD que não necessitarão de paginação.
	
	@GetMapping("/{id}")
	public Optional<Placa> get(@PathVariable("id") Long id) throws CustomException{
		return service.obter(id);
	}
	
	@PostMapping()
	public void post(@Valid @RequestBody Placa placa) throws CustomException {
//		throw new SQLException();
		System.out.println(placa);
		service.atualizar(placa);
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
