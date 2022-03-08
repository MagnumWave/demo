package com.softtek.labelling.demo.serviceImpl;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.softtek.labelling.demo.handler.CustomException;
import com.softtek.labelling.demo.service.ServicePaginated;


public abstract class ServicePaginatedImpl<T,L> implements ServicePaginated<T,L> {
	
	public abstract JpaRepository<T,L> getRepository();
	

	@Override
	public Page<T> getAll(Pageable pageable) {
		// TODO Auto-generated method stub
		return this.getRepository().findAll(pageable);
	}

}
