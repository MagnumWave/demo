package com.softtek.labelling.demo.serviceImpl;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.labelling.demo.domain.Placa;
import com.softtek.labelling.demo.handler.CustomException;
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
	public Placa obter(Long id) throws CustomException {
		// TODO Auto-generated method stub
		try {
			Placa placaTemp = repository.findById(id).get();
			return placaTemp;
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			throw new CustomException("Este ID não existe!");
		}
		
	}

	@Override
	public void inserir(Placa placa) throws CustomException {
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
	public void atualizar(Placa placa) throws CustomException {
		// TODO Auto-generated method stub
		try {
			Long idTemp = placa.getId();
			repository.findById(idTemp).get();
			//a linha acima é a testada
			repository.save(placa);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			throw new CustomException("Este ID não existe!");
		}
		
	}

	@Override
	public void remover(Long id) throws CustomException {
		// TODO Auto-generated method stub
		try {
			repository.findById(id).get();
			//a linha acima é a testada
			repository.deleteById(id);
		} catch (NoSuchElementException e) {
			// TODO: handle exception
			throw new CustomException("Este ID não existe!");
		}
		
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
