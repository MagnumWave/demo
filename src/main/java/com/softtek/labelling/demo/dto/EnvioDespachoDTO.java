package com.softtek.labelling.demo.dto;

import java.util.Date;
import java.util.List;

import lombok.Data;

@Data
public class EnvioDespachoDTO {
	private List<String> markNumbers;
	private Date data;
	private Long modal_id;
}
