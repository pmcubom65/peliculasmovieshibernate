package dao;

import java.util.List;

public interface Dao<T, K> {

    default public void persist(T entity) {};
    
    default public void update(T entity){};
     
    default public T findById(K id){ return null;};
     
    default public void delete(T entity){};
     
    default public List<T> findAll(){ return null;};
     
    default  public void deleteAll(){};
	
}
