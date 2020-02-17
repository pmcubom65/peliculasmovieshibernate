package dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import modelo.Categoria;

public class CategoriaDao implements Dao<Categoria, String> {

	private Session currentSession;

	private Transaction currentTransaction;

	public CategoriaDao() {
	}

	public Session openCurrentSession() {
		currentSession = getSessionFactory().openSession();
		return currentSession;
	}

	public Session openCurrentSessionwithTransaction() {
		currentSession = getSessionFactory().openSession();
		currentTransaction = currentSession.beginTransaction();
		return currentSession;
	}
	
	private static SessionFactory getSessionFactory() {
		Configuration configuration = new Configuration().configure();
		configuration.addAnnotatedClass(modelo.Categoria.class);
		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
				.applySettings(configuration.getProperties());
		SessionFactory sessionFactory = configuration.buildSessionFactory(builder.build());
		return sessionFactory;
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

	public void persist(Categoria c) {
		getCurrentSession().save(c);
	}

	public void update(Categoria entity) {
		getCurrentSession().update(entity);

	}

	public Categoria findById(String id) {
		Categoria c = (Categoria) getCurrentSession().find(Categoria.class, id);

		return c;
	}

	public void delete(Categoria entity) {
		getCurrentSession().delete(entity);

	}

	public List<Categoria> findAll() {

		List<Categoria> lalista = (List<Categoria>) getCurrentSession().createQuery("from Categoria").list();
		return lalista;

	}

	public void deleteAll() {
		List<Categoria> lalista = (List<Categoria>) getCurrentSession().createQuery("from Categoria").list();
		lalista.forEach(i -> getCurrentSession().delete(i));
	}

}
