package br.com.praticajpa.crud.unit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	
	private static final EntityManagerFactory FACTORY = Persistence
			.createEntityManagerFactory("crud");
	
	public static EntityManager getEntityManager() {
		return FACTORY.createEntityManager();
	}
	

}
