package com.softtek.labelling.demo.service;

import java.util.List;

import com.softtek.labelling.demo.domain.Placa;
import com.softtek.labelling.demo.handler.CustomException;

public interface PlacaService {
	List<Placa> obterTodos();
	Placa obter(Long id) throws CustomException;
	void inserir(Placa placa) throws CustomException;
	void atualizar(Placa placa) throws CustomException;
	void remover(Long id) throws CustomException;
	Placa encontrarPeloMarkNumber(String markNumber);
	Long obterUltimoID();
}
