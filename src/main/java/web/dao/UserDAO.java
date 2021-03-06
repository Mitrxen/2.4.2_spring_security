package web.dao;

import java.util.List;

import web.model.User;

public interface UserDAO {
	
	List<User> getAllUsers();
	
	User getUserById(int id);
	
	User getUserByName(String name);
	
	void addUser(User user);

	void editUser(int id, User user);
	
	void removeUser(int id);
	
}
