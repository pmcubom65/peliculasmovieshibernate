package dao;

import java.util.List;

public interface Dao<T, K> {

    public void persist(T entity);
    
    public void update(T entity);
     
    public T findById(K id);
     
    public void delete(T entity);
     
    public List<T> findAll();
     
    public void deleteAll();
	
}
