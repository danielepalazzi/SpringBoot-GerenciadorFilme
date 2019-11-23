package com.daniele.filmesapi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="filme")
public class Filme {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(name = "titulo", nullable = false)
	private String titulo;
	
	@Column(name = "diretor", nullable = false)
	private String diretor;
	
	//@ManyToOne
	//@JoinColumn(name = "genero_id", referencedColumnName = "id")
	@Column(name = "genero_id", nullable = false)
	private Integer genero;
	
	@Column(name = "sinopse")
	private String sinopse;
	
	@Column(name = "ano", nullable = true)
	private Integer ano;
	
	public Filme() {
		
	}

	public Filme(String titulo, String diretor, Integer genero, String sinopse, Integer ano) {
		this.titulo = titulo;
		this.diretor = diretor;
		this.genero = genero;
		this.sinopse = sinopse;
		this.ano = ano;
	}
	
	
	
	public long getId() {
	    return id;
	}
	
	public void setId(long id) {
        this.id = id;
    }
	
	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDiretor() {
		return diretor;
	}

	public void setDiretor(String diretor) {
		this.diretor = diretor;
	}
	
	public Integer getGenero() {
		return genero;
	}

	public void setGenero(Integer genero) {
		this.genero = genero;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}
	
	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	@Override
	public String toString() {
		return "Filme [id=" + id + ", titulo=" + titulo + ", diretor=" + diretor + ", genero=" + genero + ", sinopse="
				+ sinopse + ", ano=" + ano + "]";
	}
	
	
	

}
