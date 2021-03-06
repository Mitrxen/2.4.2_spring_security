package web.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import web.dao.UserDAO;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{
	
	private final UserDAO userDao;
	
	public UserDetailsServiceImpl(UserDAO userDao) {
		this.userDao = userDao;
	}
	
	
	@Override
	@Transactional
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return userDao.getUserByName(username);
	}

}
