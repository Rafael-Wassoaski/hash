package HashLogin.HashLogin.Database;

import java.util.List;

import javax.persistence.EntityManager;

import HashLogin.HashLogin.Entidades.User;

public interface DBUtil {

	public EntityManager getDB();

	public void addUser(User user);
	public void addUser(List<User> userList);
	public User getUser(String nome);
	public List<User> getUsers();
	public void removeUser(User user);

	public void updateDB();
	public void update(Object object);

	public void close();
}