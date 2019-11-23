package com.daniele.filmesapi.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;



import com.daniele.filmesapi.model.Filme;
import com.daniele.filmesapi.model.Genero;


public interface FilmeRepository extends JpaRepository<Filme, Long>{
	
	Filme findById(long id);
	
	List<Filme> findByGenero(int genero);
	
	//@Query("FROM Filme f WHERE LOWER(f.titulo) like %:searchTerm% OR LOWER(f.genero) like %:searchTerm%");
	
	/*@Query("SELECT f FROM filme f where titulo like %?1")
	List<Filme> findByTituloContaining(String titulo);
	
	@Query("SELECT f FROM filme f where genero_id like %?1")
	List<Filme> findByGeneroIdIs(int genro_id);*/

}
