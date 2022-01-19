package com.softtek.labelling.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="MODAL")
@Data
public class Modal {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY )
	@Column(name="ID")
	private Long id;
	
	@Column(name="DESCRICAO")
	private String descricao;
}
