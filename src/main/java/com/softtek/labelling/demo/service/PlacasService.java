package com.softtek.labelling.demo.service;

import java.util.List;

import com.softtek.labelling.demo.domain.Placas;

public interface PlacasService {
	List<Placas> obterTodos();
	Placas obter(Long id);
	void inserir(Placas placa);
	void atualizar(Placas placa);
	void remover(Long id);
}
