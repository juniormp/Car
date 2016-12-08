package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Manufacturer;

public class ManufacturerDAO implements ManufacturerDAOI {

	private EntityManager em;

	public ManufacturerDAO(EntityManager em) {
		this.em = em;
	}

	@Override
	public void add(Manufacturer manufacturer, boolean isTest) {
		try {
			em.getTransaction().begin();
			em.persist(manufacturer);
			if (isTest == false)
				em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	@Override
	public List<Manufacturer> list() {
		TypedQuery<Manufacturer> query = em.createQuery("from Manufacturer", Manufacturer.class);
		return query.getResultList();
	}

	@Override
	public Manufacturer find(int id) {
		return em.find(Manufacturer.class, id);
	}

	public Manufacturer findByNameAndAdress(String name, String adress) {
		try {
			TypedQuery<Manufacturer> query = em.createNamedQuery("findByNameAndAdress", Manufacturer.class);
			query.setParameter("name", name);
			query.setParameter("adress", adress);
			Manufacturer manufacturer = (Manufacturer) query.getSingleResult();
			return manufacturer;
		} catch (NoResultException e) {
			return null;
		}
	}
	
	
}
