package dao;

import java.util.List;

import modelo.Categoria;

public class CategoriaDaoServicio {

	private CategoriaDao categoriadao;
	
	public CategoriaDaoServicio() {
		categoriadao=new CategoriaDao();
	}
	
	
    public void persist(Categoria entity) {
    	categoriadao.openCurrentSessionwithTransaction();
    	categoriadao.persist(entity);
    	categoriadao.closeCurrentSessionwithTransaction();
    }
 
    public void update(Categoria entity) {
    	categoriadao.openCurrentSessionwithTransaction();
    	categoriadao.update(entity);
    	categoriadao.closeCurrentSessionwithTransaction();
    }
	
    public Categoria findById(String id) {
    	categoriadao.openCurrentSession();
        Categoria c = categoriadao.findById(id);
        categoriadao.closeCurrentSession();
        return c;
    }
 
    public void delete(String id) {
    	categoriadao.openCurrentSessionwithTransaction();
        Categoria c = categoriadao.findById(id);
        categoriadao.delete(c);
        categoriadao.closeCurrentSessionwithTransaction();
    }
    
    
    public List<Categoria> findAll() {
    	categoriadao.openCurrentSession();
        List<Categoria> c = categoriadao.findAll();
        categoriadao.closeCurrentSession();
        return c;
    }
 
    public void deleteAll() {
    	categoriadao.openCurrentSessionwithTransaction();
    	categoriadao.deleteAll();
    	categoriadao.closeCurrentSessionwithTransaction();
    }
 
    public CategoriaDao bookDao() {
        return categoriadao;
    }
	
	
}
