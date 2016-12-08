package br.com.fiap.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerDAO {

	private static EntityManager entityManager;

	private EntityManagerDAO() {

	}

	public static EntityManager getInstance() {

		if (entityManager == null) {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mysql");
			entityManager = entityManagerFactory.createEntityManager();
		}

		return entityManager;

	}

}
