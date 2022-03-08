package com.softtek.labelling.demo.service;

import java.util.Optional;

import com.softtek.labelling.demo.domain.Placa;
import com.softtek.labelling.demo.handler.CustomException;

public interface PlacaService extends ServicePaginated<Placa,Long>{
	//agora esta interface service faz extend da ServicePaginated
	
//	List<Placa> obterTodos();
	Optional<Placa> obter(Long id) throws CustomException;
	void inserir(Placa placa) throws CustomException;
	void atualizar(Placa placa) throws CustomException;
	void remover(Long id) throws CustomException;
	Placa encontrarPeloMarkNumber(String markNumber);
	Long obterUltimoID();
	
	//métodos se sempre se mantêm, mas a obterTodos() passa a ser implementada pela paginação.
}
