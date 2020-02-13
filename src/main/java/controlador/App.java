package controlador;

import dao.PeliculaDao;
import dao.PeliculaDaoServicio;
import modelo.Pelicula;

public class App {

	public static void main(String[] args) {
		Pelicula p1=new Pelicula("40", "Indiana Jones", "Lucas L", "1983", "1");
		PeliculaDaoServicio pds=new PeliculaDaoServicio();
		System.out.println(pds.findById("1"));
	}
	
	
}
