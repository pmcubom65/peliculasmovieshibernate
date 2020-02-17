package controlador;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.hql.internal.classic.SelectPathExpressionParser;

import dao.CategoriaDao;
import dao.CategoriaDaoServicio;
import dao.PeliculaDao;
import dao.PeliculaDaoServicio;
import modelo.Categoria;
import modelo.Pelicula;

public class App {

	public static void main(String[] args) {
		Pelicula p1=new Pelicula("40", "Indiana Jones", "Lucas L", "1983", "1");
		PeliculaDaoServicio pds=new PeliculaDaoServicio();
			
	System.out.println(pds.aplicarProcedimiento());
		
		Categoria c=new Categoria("20", "Musical", "Actores bailando");
		
		
		CategoriaDaoServicio cds=new CategoriaDaoServicio();
		cds.delete("10");
		System.out.println(cds.findAll());
	
		
		
		
		
	}
	
	
}
