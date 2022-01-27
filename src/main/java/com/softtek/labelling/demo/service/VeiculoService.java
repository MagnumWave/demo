package com.softtek.labelling.demo.service;

import java.util.List;

import com.softtek.labelling.demo.domain.Veiculo;

public interface VeiculoService {
	List<Veiculo> obterTodos();
	Veiculo obter(Long id);
	void inserir(Veiculo veiculo);
	void atualizar(Veiculo veiculo);
	void remover(Long id);
}
