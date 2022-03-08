package com.softtek.labelling.demo.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.softtek.labelling.demo.handler.CustomException;

public interface ServicePaginated<T,L> {
//	void save(T obj);
//	void remove(T obj);
//	void update(T obj);
	Page<T> getAll(Pageable pageable);
//	Optional<T> get(L id) throws CustomException;
	
	//aqui fica apenas a parte do CRUD que interessa ser paginada.
}
