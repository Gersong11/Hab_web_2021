package com.ufps.web.examen.controllers;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ufps.web.examen.entities.Connectiontoken;
import com.ufps.web.examen.entities.Usuario;
import com.ufps.web.examen.repository.IConnectionToken;
import com.ufps.web.examen.repository.IUsuarioDao;

@RequestMapping("/token")
@Controller
public class TokenController {

	@Autowired
	private IConnectionToken conexionDao;
	
	@Autowired
	private IUsuarioDao usuarioDao;
	
	@GetMapping
	public String registrar(Model model) {
		return "registrarToken";
	}
	
	@PostMapping
	public String registrar(Connectiontoken token, Model model, Principal principal ) {
		if(token == null) {
			return "registrarToken";
		}
		Usuario usuario = usuarioDao.findByEmail(principal.getName());
		token.setUsuario(usuario);
		conexionDao.save(token);
		
		return "redirect:/inicio";
	}
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("token", conexionDao.findAll());
		return "listarToken";
	}
}
