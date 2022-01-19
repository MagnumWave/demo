package com.softtek.labelling.demo.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Entity
@Table(name="DESPACHO")
@Data
public class Despacho {
	
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	@Column(name="ID")
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "PLACA_ID")
	private Placa placa;
	
	@Column(name="DATA")
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date data;
	
	@ManyToOne
	@JoinColumn(name = "MODAL_ID")
	private Modal modal;
}
