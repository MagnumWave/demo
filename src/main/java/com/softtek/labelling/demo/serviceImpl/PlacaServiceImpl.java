package com.softtek.labelling.demo.serviceImpl;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.softtek.labelling.demo.domain.Placa;
import com.softtek.labelling.demo.handler.CustomException;
import com.softtek.labelling.demo.repository.PlacaRepository;
import com.softtek.labelling.demo.service.PlacaService;

@Service
public class PlacaServiceImpl extends ServicePaginatedImpl<Placa, Long> implements PlacaService {
	//antes esta classe apenas implentava a service relativa (Placaservice)
	//agora ela faz extend da classe ServicePaginated antes de implementar a service.
	
	@Autowired
	PlacaRepository repository;
	
	//Sobrescreve a implementação do novo "obterTodos()"
	
	@Override
	public JpaRepository<Placa, Long> getRepository() {
		// TODO Auto-generated method stub
		return repository;
	}
	
	@Override
	public Optional<Placa> obter(Long id) throws CustomException{
		// TODO Auto-generated method stub
		Optional<Placa> aux = this.getRepository().findById(id);
		System.out.println(aux);
		if (aux.isEmpty()) {
			throw new CustomException("Este ID non-ecziste!!!");
		} else {
			return aux;
		}
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
			String markNumberTemp = repository.getById(ultimoID).getMarkNumber();
//			String markNumberTemp = this.get(ultimoID).getMarkNumber();
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
