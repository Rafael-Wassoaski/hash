package HashLogin.HashLogin.Database;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import org.hibernate.Session;

import HashLogin.HashLogin.Entidades.User;

public class HibernateUtil implements DBUtil {
	private static EntityManagerFactory dbFac;
	private String persistenceUnit;

	public HibernateUtil(String persistenceUnit) {
		this.persistenceUnit = persistenceUnit;
	}
	
	public void addUser(User user) {
		add(user);
	}
	
	public void addUser(List<User> userList) {
		for(User user : userList) {
			add(user);
		}
	}
	
	public User getUser(String nome) {
		EntityManager db = getDB();
		User user = db.find(User.class, nome);
		db.close();
		return user;
	}
	
	@SuppressWarnings("unchecked")
	public List<User> getUsers(){
		EntityManager db = getDB();
		List<User> users = db.createQuery("from User").getResultList();
		db.close();
		return users;
	}
	
	public void removeUser(User user) {
		remove(user);
	}

/*---------------------------------------------------------*/
	
	private void add(Object object) {
		EntityManager db = getDB();
		EntityTransaction transac = db.getTransaction();
		transac.begin();
		db.persist(object);
		transac.commit();
		db.close();
	}

	private void remove(Object object) {
		EntityManager db = getDB();
		EntityTransaction transac = db.getTransaction();
		transac.begin();
		db.remove(object);
		transac.commit();
		db.close();
	}
	
	public void update(Object object) {
		EntityManager db = getDB();
		EntityTransaction transac = db.getTransaction();
		transac.begin();
		db.unwrap(Session.class).update(object);
		
		transac.commit();
		db.close();
	}

	public void updateDB() {
		EntityManager db = getDB();
		EntityTransaction transac = db.getTransaction();
		transac.begin();
		transac.commit();
		db.close();
	}

	public EntityManager getDB() {
		if (dbFac == null)
			dbFac = Persistence.createEntityManagerFactory(persistenceUnit);
		return dbFac.createEntityManager();
	}

	public void close() {

		if (dbFac == null)
			return;
		if (!dbFac.isOpen())
			return;

		dbFac.close();
	}
}
