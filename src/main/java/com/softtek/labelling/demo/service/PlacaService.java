package com.softtek.labelling.demo.service;

import java.util.List;

import com.softtek.labelling.demo.domain.Placa;

public interface PlacaService {
	List<Placa> obterTodos();
	Placa obter(Long id);
	void inserir(Placa placa);
	void atualizar(Placa placa);
	void remover(Long id);
	Placa encontrarPeloMarkNumber(String markNumber);
	Long obterUltimoID();
}
