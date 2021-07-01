package com.ufps.web.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufps.web.examen.entities.Typedb;

public interface ITypeDao extends JpaRepository<Typedb, Integer> {

}
