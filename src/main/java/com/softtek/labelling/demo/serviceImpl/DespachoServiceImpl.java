package com.softtek.labelling.demo.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.softtek.labelling.demo.domain.Despacho;
import com.softtek.labelling.demo.domain.Modal;
import com.softtek.labelling.demo.dto.EnvioDespachoDTO;
import com.softtek.labelling.demo.repository.DespachoRepository;
import com.softtek.labelling.demo.service.DespachoService;
import com.softtek.labelling.demo.service.ModalService;
import com.softtek.labelling.demo.service.PlacaService;

@Service
public class DespachoServiceImpl implements DespachoService {
	
	@Autowired
	DespachoRepository repository;
	
	@Autowired
	PlacaService placaService;
	
	@Autowired
	ModalService modalService;
	
	@Override
	public List<Despacho> obterTodos() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Despacho obter(Long id) {
		// TODO Auto-generated method stub
		return repository.findById(id).get();
	}

	@Override
	public void inserir(Despacho despacho) {
		// TODO Auto-generated method stub
		repository.save(despacho);
		
	}

	@Override
	public void atualizar(Despacho despacho) {
		// TODO Auto-generated method stub
		repository.save(despacho);
	}

	@Override
	public void remover(Long id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);
	}

	@Override
	public void enviar(EnvioDespachoDTO envio) {
		// TODO Auto-generated method stub
		List<Despacho> despachosTemp = new ArrayList<Despacho>();
		Modal modal = modalService.obter(envio.getModal_id());
		for (String markNumber : envio.getMarkNumbers()) {
			Despacho despacho = new Despacho();
			despacho.setPlaca(placaService.encontrarPeloMarkNumber(markNumber));
			despacho.setModal(modal);
			despacho.setData(envio.getData());
			despachosTemp.add(despacho);
		}
		repository.saveAll(despachosTemp);
	}

	

	

}
