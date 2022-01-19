package com.softtek.labelling.demo.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

@Data
public class EnvioDespachoDTO {
	private List<String> markNumbers;
	@JsonFormat (shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss")
	private Date data;
	private Long modal_id;
}
