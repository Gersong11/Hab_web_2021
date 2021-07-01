package com.ufps.web.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufps.web.examen.entities.Rol;

public interface IRolDao extends JpaRepository<Rol, Integer> {

	public Rol findByDescription(String descripcion);
}
