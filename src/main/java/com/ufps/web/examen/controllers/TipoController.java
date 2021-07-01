package com.ufps.web.examen.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ufps.web.examen.entities.Typedb;
import com.ufps.web.examen.repository.ITypeDao;

@RequestMapping("/tipo")
@Controller
public class TipoController {

	@Autowired
	private ITypeDao tipoDao;
	
	@GetMapping
	public String registrar(Model model) {
		return "tipo";
	}
	
	@PostMapping
	public String registrar(Typedb tipo, Model model) {
		if(tipo == null) {
			return "tipo";
		}
		tipoDao.save(tipo);
		return "redirect:/inicio";
	}
}
