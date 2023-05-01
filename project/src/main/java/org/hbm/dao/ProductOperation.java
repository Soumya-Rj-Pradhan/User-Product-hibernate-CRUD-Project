package org.hbm.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hbm.dto.Product;
import org.hbm.dto.User;

public class ProductOperation {
	EntityManager manager = Persistence.createEntityManagerFactory("dev").createEntityManager();
	EntityTransaction t =  manager.getTransaction();
	
	public Product saveProduct(Product p, int uid) {
		User u = manager.find(User.class, uid);
		if(u!=null) {
			u.getProducts().add(p);
			p.setUser(u);
			manager.persist(p);
			t.begin();
			t.commit();
			return p;
		}
		return null;
	}
	
	public Product updateProduct(Product p , int uid) {
		User u = manager.find(User.class, uid);
		if(u!=null) {
			u.getProducts().add(p);
			p.setUser(u);
			manager.merge(p);
			t.begin();
			t.commit();
			return p;
		}
		return null;
	}
	
	public Product findProductId(int id) {
		return manager.find(Product.class, id);
	}
	
	public boolean deleteProduct(int id) {
		Product u = findProductId(id);
		if(u!=null) {
			manager.remove(u);
			t.begin();
			t.commit();
			return true;
		}
		return false;
	}
	
	public List<Product> findProductByUserId(int uid) {
		Query q = manager.createQuery("select u.products from User u where u.id=?1");
		q.setParameter(1, uid);
		return q.getResultList();
	}
}
