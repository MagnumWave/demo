package com.softtek.labelling.demo.service;

import java.util.List;

import com.softtek.labelling.demo.domain.Modal;

public interface ModalService {
	List<Modal> obterTodos();
	Modal obter(Long id);
	void inserir(Modal modal);
	void atualizar(Modal modal);
	void remover(Long id);
}
