package com.daniele.filmesapi.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.daniele.filmesapi.model.Filme;
import com.daniele.filmesapi.model.Genero;
import com.daniele.filmesapi.repository.FilmeRepository;
import com.daniele.filmesapi.repository.GeneroRepository;


@CrossOrigin(origins = "http://localhost:4200") //porta padrao do Angular
@RestController 
@RequestMapping(path = "/api")
public class FilmeController {
	
	@Autowired
	FilmeRepository filmeRepository;
	GeneroRepository generoRepository;
	
	@Autowired

	
	//OK
	//Busca todos os filmes
	@GetMapping("/filmes")
	public ResponseEntity <List<Filme>> getAllFilmes() {

		List<Filme> f = new ArrayList<>();
		try {
			filmeRepository.findAll().forEach(f::add);
			
			if (f.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(f, HttpStatus.OK);
			
		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
		
		
	//OK
	//Busca filme pelo ID
	@GetMapping(path="filmes/{id}")
	public ResponseEntity getOneFilme(@PathVariable("id") long id) {
			 
		return ResponseEntity.ok().body(filmeRepository.findById(id));
	}
	
	// Nao funcionou, problema no repository !
	//Busca filme pelo titulo
	/*@GetMapping("/filmes/search/{titulo}")
	public ResponseEntity <List<Filme>> findByTituloContaining(@PathVariable("titulo") String titulo) {

		List<Filme> f = new ArrayList<>();
		try {
			filmeRepository.findByTituloContaining(titulo).forEach(f::add);

			if (f.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(f, HttpStatus.OK);

		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
	
	// Nao funcionou !
	//Busca filme pelo genero
	/*@GetMapping("/filmes/search/{genero_id}")
	public ResponseEntity <List<Filme>> findByGeneroIdIs(@PathVariable("genero_id") int genero_id) {

		List<Filme> f = new ArrayList<>();
		try {
			filmeRepository.findByGeneroIdIs(genero_id).forEach(f::add);

			if (f.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(f, HttpStatus.OK);

		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/
	
	
	
	
	//Busca filme pelo genero
	@GetMapping("/filmes/search/{genero_id}")
	public ResponseEntity <List<Filme>> findByGenero(@PathVariable("genero_id") int genero_id) {

		List<Filme> f = new ArrayList<>();
		try {
			filmeRepository.findByGenero(genero_id).forEach(f::add);

			if (f.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(f, HttpStatus.OK);

		}catch (Exception e){
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	//OK	
	// Apaga um filme
	@DeleteMapping("/filmes/{id}")
	public ResponseEntity<HttpStatus> deletaFilme(@PathVariable("id") long id) {
		try {
			filmeRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	//OK
	//Atualiza um filme
	@PutMapping("/filmes/{id}")
	public ResponseEntity<Filme> atualizaFilme(@PathVariable(value = "id") Long id, @RequestBody Filme filme)  {
		Optional<Filme> f = filmeRepository.findById(id);

		if(f.isPresent()) {
			Filme fUpdate = f.get();
			fUpdate.setTitulo(filme.getTitulo());
			fUpdate.setDiretor(filme.getDiretor());
			fUpdate.setGenero(filme.getGenero());
			fUpdate.setSinopse(filme.getSinopse());
			fUpdate.setAno(filme.getAno());
			return new ResponseEntity<>(filmeRepository.save(fUpdate), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
		}

	}
	
	//OK
	//Adiciona um filme

	@PostMapping(value = "/filmes")
	public ResponseEntity<Filme> addFilme(@RequestBody Filme filme) {
		try {
			
			Filme f = filmeRepository.save(new Filme(filme.getTitulo(), filme.getDiretor(), filme.getGenero(), filme.getSinopse(), filme.getAno()));
			return new ResponseEntity<>(f, HttpStatus.CREATED);

		}catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	
		
	//NAO!
	//Busca todos os generos
	@GetMapping("/filmes/genero")
	public ResponseEntity <List<Genero>> findAll() {

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
			
		

	//NAO 
	@GetMapping(path="/filmes/genero/{id}")
	public ResponseEntity findById(@PathVariable("id") long id) {

		return ResponseEntity.ok().body(generoRepository.findById(id));
	}

	
			

}
