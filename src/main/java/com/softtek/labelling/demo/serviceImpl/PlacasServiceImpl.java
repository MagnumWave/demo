package com.softtek.labelling.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.labelling.demo.domain.Placas;
import com.softtek.labelling.demo.repository.PlacasRepository;
import com.softtek.labelling.demo.service.PlacasService;

@Service
public class PlacasServiceImpl implements PlacasService {
	
	@Autowired
	PlacasRepository repository;

	@Override
	public List<Placas> obterTodos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Placas obter(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public void inserir(Placas placa) {
		// TODO Auto-generated method stub
		repository.save(placa);
		
	}

	@Override
	public void atualizar(Placas placa) {
		// TODO Auto-generated method stub
		repository.save(placa);
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
