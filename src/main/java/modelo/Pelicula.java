package modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


@NamedStoredProcedureQuery(procedureName = "peliculasbefore2011", name = "test")
@Entity(name="Pelicula")
@Table(name="movies")
public class Pelicula {

	@Id
	@Column(name="movie_id")
	private String movie_id;
	
	@Column(name="title")	
	private String titulo;
	
	@Column(name="director")
	private String director;
	
	@Column(name="year_released")
	private String anyo;
	
	@Column(name="category_id")
	private String categoria;
	

	
	public Pelicula() {}


	public Pelicula(String titulo, String director, String anyo, String categoria) {
	
		this.titulo = titulo;
		this.director = director;
		this.anyo = anyo;
		this.categoria = categoria;
	
	}


	public Pelicula(String id, String titulo, String director, String anyo, String categoria) {
		
		this.titulo = titulo;
		this.director = director;
		this.anyo = anyo;
		this.categoria = categoria;
		this.movie_id=id;
	
	}
	
	
	

	public String getMovie_id() {
		return movie_id;
	}


	public void setMovie_id(String movie_id) {
		this.movie_id = movie_id;
	}


	public String getTitulo() {
		return titulo;
	}


	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}


	public String getDirector() {
		return director;
	}


	public void setDirector(String director) {
		this.director = director;
	}


	public String getAnyo() {
		return anyo;
	}


	public void setAnyo(String anyo) {
		this.anyo = anyo;
	}

	
	public String getCategoria() {
		return categoria;
	}

	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}


	@Override
	public String toString() {
		return "Pelicula [movie_id=" + movie_id + ", titulo=" + titulo + ", director=" + director + ", anyo=" + anyo
				+ ", categoria=" + categoria + "]";
	}



	
	
	
	
}
