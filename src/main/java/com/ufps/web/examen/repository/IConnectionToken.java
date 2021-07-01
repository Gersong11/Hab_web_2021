package com.ufps.web.examen.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ufps.web.examen.entities.Connectiontoken;

public interface IConnectionToken extends JpaRepository<Connectiontoken, Integer> {

}
