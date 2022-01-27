package com.softtek.labelling.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.labelling.demo.domain.Veiculo;
import com.softtek.labelling.demo.repository.VeiculoRepository;
import com.softtek.labelling.demo.service.VeiculoService;

@Service
public class VeiculoServiceImpl implements VeiculoService {
	
	@Autowired
	VeiculoRepository repository;

	@Override
	public List<Veiculo> obterTodos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Veiculo obter(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public void inserir(Veiculo veiculo) {
		// TODO Auto-generated method stub
		repository.save(veiculo);
		
	}

	@Override
	public void atualizar(Veiculo veiculo) {
		// TODO Auto-generated method stub
		repository.save(veiculo);
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
