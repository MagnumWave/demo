package com.softtek.labelling.demo.domain;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Entity
@Table(name="PLACA")
@Data
public class Placa {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	@Column(name="ID")
	private Long id;
	
	@NotNull(message = "Mark number é obrigatório")
	@Column(name="MARK_NUMBER")
	private String markNumber;
	
	@NotNull(message = "Código SAP é obrigatório")
	@Column(name="CODIGO_SAP")
	private Long codigoSap;
	
	@NotNull(message = "Peso é obrigatório")
	@Column(name="PESO")
	private BigDecimal peso;
	
	@NotNull(message = "Altura é obrigatório")
	@Column(name="ALTURA")
	private BigDecimal altura;
	
	@NotNull(message = "Largura é obrigatório")
	@Column(name="LARGURA")
	private BigDecimal largura;
	
	@NotNull(message = "Espessura é obrigatório")
	@Column(name="ESPESSURA")
	private BigDecimal espessura;
	
}
