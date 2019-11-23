package com.daniele.filmesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daniele.filmesapi.model.Filme;
import com.daniele.filmesapi.model.Genero;

public interface GeneroRepository extends JpaRepository<Genero, Long> {
	
	Genero findById(long id);

}
