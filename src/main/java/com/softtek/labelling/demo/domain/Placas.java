package com.softtek.labelling.demo.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="PLACAS")
@Data
public class Placas {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	@Column(name="ID")
	private Long id;
	
	@Column(name="MARK_NUMBER")
	private String mark_number;
	
	@Column(name="CODIGO_SAP")
	private Long codigo_sap;
	
	@Column(name="PESO")
	private BigDecimal peso;
	
	@Column(name="ALTURA")
	private BigDecimal altura;
	
	@Column(name="LARGURA")
	private BigDecimal largura;
	
	@Column(name="ESPESSURA")
	private BigDecimal espessura;
	
}
