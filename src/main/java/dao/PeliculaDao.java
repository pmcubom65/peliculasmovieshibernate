package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NamedStoredProcedureQuery;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import modelo.Pelicula;



public class PeliculaDao implements Dao<Pelicula, String> {

    private Session currentSession;
    
    private Transaction currentTransaction;
	
	public PeliculaDao() {}
	
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(modelo.Pelicula.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
	}
	
	
    public Session openCurrentSessionwithTransaction() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
	
	
	
	
	
    public Session openCurrentSession() {
        currentSession = getSessionFactory().openSession();
        currentTransaction = currentSession.beginTransaction();
        return currentSession;
    }
	
    public void closeCurrentSession() {
        currentSession.close();
    }

    public void closeCurrentSessionwithTransaction() {
        currentTransaction.commit();
        currentSession.close();
    }

	public Session getCurrentSession() {
		return currentSession;
	}


	public void setCurrentSession(Session currentSession) {
		this.currentSession = currentSession;
	}


	public Transaction getCurrentTransaction() {
		return currentTransaction;
	}


	public void setCurrentTransaction(Transaction currentTransaction) {
		this.currentTransaction = currentTransaction;
	}


	public void persist(Pelicula entity) {
		getCurrentSession().save(entity);
		
	}

	public void update(Pelicula entity) {
		getCurrentSession().update(entity);
		
	}

	public Pelicula findById(String id) {
		
		Pelicula pelicula=(Pelicula) getCurrentSession().get(modelo.Pelicula.class, id);
		return pelicula;
	}

	public void delete(Pelicula entity) {
		getCurrentSession().delete(entity);
		
	}

	public List<Pelicula> findAll() {
		Query query = getCurrentSession().createQuery("from Pelicula");
		List<Pelicula> listado=(List<Pelicula>) query.list();
	
		return listado;
		}

	public void deleteAll() {
		findAll().forEach(i->getCurrentSession().delete(i));
		
	}
	
	
	public List<Pelicula> procedimiento() {

			Query query =	getCurrentSession().createNativeQuery("call peliculasbefore2011()");
			
			List<Object[]> listado=query.list();
			List<Pelicula> listados=new ArrayList<>();
			
			for(Object[] row : listado){
				Pelicula p=new Pelicula();
				p.setTitulo(row[1].toString());
				p.setDirector(row[2].toString());
				p.setMovie_id(row[0].toString());
				p.setAnyo(row[3].toString());
				p.setCategoria(row[4].toString());
				listados.add(p);
			
			}
			return listados;
		}
	

	
}
