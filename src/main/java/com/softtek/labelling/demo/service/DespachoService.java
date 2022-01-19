package com.softtek.labelling.demo.service;

import java.util.List;

import com.softtek.labelling.demo.domain.Despacho;
import com.softtek.labelling.demo.dto.EnvioDespachoDTO;

public interface DespachoService {
	List<Despacho> obterTodos();
	Despacho obter(Long id);
	void inserir(Despacho despacho);
	void atualizar(Despacho despacho);
	void remover(Long id);
	//utilizando DTO!!!
	void enviar(EnvioDespachoDTO envio);
}
