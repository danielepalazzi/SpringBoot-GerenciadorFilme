package com.daniele.filmesapi.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="genero")
public class Genero {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "nomegenero", nullable = false)
	private String nomeGenero;
	
	//@OneToMany(mappedBy = "genero")
		//@OneToMany (mappedBy = "genero", fetch = FetchType.EAGER)
	    //private List<Filme> filmes;
		

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getNomeGenero() {
			return nomeGenero;
		}

		public void setNomeGenero(String nomeGenero) {
			this.nomeGenero = nomeGenero;
		}

		/*public List<Filme> getFilmes() {
	        return filmes;
	    }*/
		
	

	/*@Override
	public String toString() {
		return "Genero [id=" + id + ", nomeGenero=" + nomeGenero + "]";
	}*/
		
		

}
