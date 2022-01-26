package com.softtek.labelling.demo.handler;

public class MarkNumberIsNullException extends Exception {
	
	public MarkNumberIsNullException() {
		super("Mark number é um campo obrigatório");
	}
	
}
