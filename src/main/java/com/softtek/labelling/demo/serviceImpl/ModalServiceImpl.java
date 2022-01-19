package com.softtek.labelling.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.labelling.demo.domain.Modal;
import com.softtek.labelling.demo.repository.ModalRepository;
import com.softtek.labelling.demo.service.ModalService;

@Service
public class ModalServiceImpl implements ModalService {
	
	@Autowired
	ModalRepository repository;

	@Override
	public List<Modal> obterTodos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Modal obter(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public void inserir(Modal modal) {
		// TODO Auto-generated method stub
		repository.save(modal);
		
	}

	@Override
	public void atualizar(Modal modal) {
		// TODO Auto-generated method stub
		repository.save(modal);
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

}
