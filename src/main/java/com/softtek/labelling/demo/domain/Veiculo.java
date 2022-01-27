package com.softtek.labelling.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="VEICULO")
@Data
public class Veiculo {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	@Column(name="ID")
	private Long id;
	
	
	@Column(name = "PLACA")
	private String placa;
	
	@Column(name = "FABRICANTE")
	private String fabricante;
	
	@Column(name = "MODELO")
	private String modelo;
	
	@Column(name = "ANO")
	private String ano;
	
	@Column(name = "COR")
	private String cor;
	
	@ManyToOne
	@JoinColumn(name = "MODAL_ID")
	private Modal modal;
	
}
