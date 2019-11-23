package com.daniele.filmesapi.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.daniele.filmesapi.model.Filme;
import com.daniele.filmesapi.model.Genero;
import com.daniele.filmesapi.repository.FilmeRepository;
import com.daniele.filmesapi.repository.GeneroRepository;

@Controller
@RequestMapping(path = "/api")
public class GeneroController {
	
	@Autowired
	GeneroRepository generoRepository;

	//Busca todos os generos
	@GetMapping("/genero")
	public ResponseEntity <List<Genero>> getAllGenero() {

		List<Genero> g = new ArrayList<>();
		try {
			generoRepository.findAll().forEach(g::add);
			if (g.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(g, HttpStatus.OK);

		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	


	//Busca genero pelo ID
	@GetMapping(path="/genero/{id}")
	public ResponseEntity findById(@PathVariable("id") long id) {

		return ResponseEntity.ok().body(generoRepository.findById(id));
	}

}
