package com.ufps.web.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufps.web.examen.entities.Usuario;

public interface IUsuarioDao extends JpaRepository<Usuario, Integer> {

	public Usuario findByEmail(String email);
}
