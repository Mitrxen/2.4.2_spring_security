package web.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import web.model.Role;

@Component
@Transactional
public class RoleDAOImpl implements RoleDAO{

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public Role getRoleByName(String name) {
		Role role = entityManager.createQuery("FROM Role WHERE roleName=:name", Role.class)
								.setParameter("name", name)
								.getSingleResult();
		
		return role;
	}

}
