package web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import web.dao.RoleDAO;
import web.dao.UserDAO;
import web.model.Role;
import web.model.User;

@Component
@Transactional
public class UserServiceImpl implements UserService{
	
	private final UserDAO userDao;
	private final RoleDAO roleDao;

	@Autowired
	public UserServiceImpl(UserDAO userDao, RoleDAO roleDao) {
		this.userDao = userDao;
		this.roleDao = roleDao;
	}
	
	@Override
	public User getUserByName(String username) {
		return userDao.getUserByName(username);
	}
	
	
	@Override
	public List<User> getAllUsers() {
		return userDao.getAllUsers();
	} 
	
	@Override
	public User getUserById(int id) {
		return userDao.getUserById(id);
	}
	
	@Override
	public void addUser(User user) {
		Role role = roleDao.getRoleByName("ROLE_USER");
		user.addRoleToUser(role);
		userDao.addUser(user);
	}
	
	@Override
	public void addAdmin(User user) {
		Role role = roleDao.getRoleByName("ROLE_ADMIN");
		user.addRoleToUser(role);
		this.addUser(user);
	}
	
	@Override
	public void editUser(int id, User user) {
		user.setUserRoles(userDao.getUserById(id).getUserRoles());
		userDao.editUser(id, user);
	}
	
	@Override
	public void removeUser(int id) {
		userDao.removeUser(id);
	}
	
}
