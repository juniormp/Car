package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Car;

public class CarDAO implements CarDAOI {

	private EntityManager em;

	public CarDAO(EntityManager em) {
		this.em = em;
	}

	@Override
	public void add(Car car, boolean isTest) {
		try {
			em.getTransaction().begin();
			em.persist(car);
			if(!isTest)
				em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	@Override
	public List<Car> list() {
		TypedQuery<Car> query = em.createQuery("from Car", Car.class);
		return query.getResultList();
	}

	@Override
	public Car find(int id) {
		return em.find(Car.class, id);
	}
	
	public Car findByBrandAndDes(String brand, String des) {
		try {
			TypedQuery<Car> query = em.createNamedQuery("findByBrandAndDes", Car.class);
			query.setParameter("brand", brand);
			query.setParameter("des", des);
			Car car = (Car) query.getSingleResult();
			return car;
		} catch (NoResultException e) {
			return null;
		}
	}

}
