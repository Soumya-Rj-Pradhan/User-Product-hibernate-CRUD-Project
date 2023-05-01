package org.hbm.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transaction;

import org.hbm.dto.User;

public class UserOperation {
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction t = manager.getTransaction();

	public User saveUser(User u) {
		manager.persist(u);
		t.begin();
		t.commit();
		return u;
	}

	public User updateUser(User u) {
		manager.merge(u);
		t.begin();
		t.commit();
		return u;
	}

	public User findById(int id) {
		return manager.find(User.class, id);
	}

public User verifyUser(long phone, String password) {
	Query q = manager.createQuery("select u from User u where u.phone=?1 and u.password=?2");
	q.setParameter(1, phone);
	q.setParameter(2, password);
	try {
		return (User) q.getSingleResult();
	} catch (NoResultException e) {
		return null;
	}
}

	public boolean deletUser(int id) {
		User u = findById(id);
		if(u!=null) {
			manager.remove(u);
			t.begin();
			t.commit();
			return true;
		}
		return false;
	}
}