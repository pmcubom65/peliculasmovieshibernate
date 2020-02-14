package dao;

import java.util.List;

import javax.persistence.NamedStoredProcedureQuery;

import modelo.Pelicula;

public class PeliculaDaoServicio {

	private PeliculaDao peliculadao;

	public PeliculaDaoServicio() {
		peliculadao = new PeliculaDao();
	}
	
	  public void persist(Pelicula entity) {
		  peliculadao.openCurrentSessionwithTransaction();
		  peliculadao.persist(entity);
		  peliculadao.closeCurrentSessionwithTransaction();
	    }
	 
	    public void update(Pelicula entity) {
	    	peliculadao.openCurrentSessionwithTransaction();
	    	peliculadao.update(entity);
	    	peliculadao.closeCurrentSessionwithTransaction();
	    }
	 
	    public Pelicula findById(String id) {
	    	peliculadao.openCurrentSession();
	        Pelicula p = (Pelicula) peliculadao.findById(id);
	        peliculadao.closeCurrentSession();
	        return p;
	    }
	 
	    public void delete(String id) {
	    	peliculadao.openCurrentSessionwithTransaction();
	        Pelicula pe = peliculadao.findById(id);
	        peliculadao.delete(pe);
	        peliculadao.closeCurrentSessionwithTransaction();
	    }
	 
	    public List<Pelicula> findAll() {
	    	peliculadao.openCurrentSession();
	        List<Pelicula> ps = peliculadao.findAll();
	        peliculadao.closeCurrentSession();
	        return ps;
	    }
	 
	    public void deleteAll() {
	    	peliculadao.openCurrentSessionwithTransaction();
	    	peliculadao.deleteAll();
	    	peliculadao.closeCurrentSessionwithTransaction();
	    }
	 
	    public PeliculaDao bookDao() {
	        return peliculadao;
	    }
	
	    public List<Pelicula> aplicarProcedimiento() {
	    	peliculadao.openCurrentSessionwithTransaction();
	    	List<Pelicula> pelis=peliculadao.procedimiento();
	    	peliculadao.closeCurrentSessionwithTransaction();
	    	return pelis;
	    }
	
	
}
