package com.softtek.labelling.demo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ser.std.StdArraySerializers.LongArraySerializer;
import com.softtek.labelling.demo.domain.Placa;
import com.softtek.labelling.demo.repository.PlacaRepository;
import com.softtek.labelling.demo.service.PlacaService;

@Service
public class PlacaServiceImpl implements PlacaService {
	
	@Autowired
	PlacaRepository repository;

	@Override
	public List<Placa> obterTodos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Placa obter(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public void inserir(Placa placa) {
		// TODO Auto-generated method stub
		//id do cara anterior
		Long ultimoID = this.obterUltimoID();
		//marknumber do cara anterior
		System.out.println(ultimoID);
		if (ultimoID == null) {
			placa.setMarkNumber("1");
		} else {
			String markNumberTemp = this.obter(ultimoID).getMarkNumber();
			Long longMarkNumber = Long.parseLong(markNumberTemp);
			longMarkNumber++;
			placa.setMarkNumber(longMarkNumber.toString());
		}
		
		
		
		//converte marknumber pra long, incrementa, devolve pra string
		
		
				
		repository.save(placa);
		
	}

	@Override
	public void atualizar(Placa placa) {
		// TODO Auto-generated method stub
		repository.save(placa);
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public Placa encontrarPeloMarkNumber(String markNumber) {
		// TODO Auto-generated method stub
		return repository.findByMarkNumber(markNumber);
	}

	@Override
	public Long obterUltimoID() {
		// TODO Auto-generated method stub
		return repository.getLastPlaca();
	}

}
