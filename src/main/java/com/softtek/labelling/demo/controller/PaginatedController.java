package com.softtek.labelling.demo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.softtek.labelling.demo.handler.CustomException;
import com.softtek.labelling.demo.service.ServicePaginated;

public abstract class PaginatedController<T,L> {
	
	public abstract ServicePaginated<T,L> getService();
	
	@GetMapping()
	public List<T> get() throws Exception{
		throw new CustomException("O filtro é obrigatório");
	}
	
	
	@GetMapping(value = "/page/{page}/size/{size}")
	public Page<T> getPaginate(
			@PathVariable("page") int page,
			@PathVariable("size") int size,
			@RequestParam(name="order", required = false) String order,
			@RequestParam(name="property", required = false) String property) {
		Pageable pageSetup;
		
		if(property != null) {
			Sort sortSetup = order.equals("asc") ? 
					Sort.by(property).ascending()
					: Sort.by(property).descending();
			
			pageSetup = PageRequest.of(page, size, sortSetup);
		} else {
			pageSetup = PageRequest.of(page, size);
		}
		
		return this.getService().getAll(pageSetup);		
		
	}
	
	//implementar POST, PUT e DELETE
	
//	@PostMapping()
//	public void post(@Valid @RequestBody() T obj) {
//		this.getService().save(obj);
//	}

}
