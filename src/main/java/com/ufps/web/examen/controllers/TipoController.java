package com.ufps.web.examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ufps.web.examen.repository.ITypeDao;

@RequestMapping("/tipo")
public class TipoController {

	@Autowired
	private ITypeDao tipoDao;
	
	@GetMapping
	public String registrar(Model model) {
		return "registrarType";
	}
}
