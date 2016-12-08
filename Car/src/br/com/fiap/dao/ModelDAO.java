package br.com.fiap.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import br.com.fiap.entity.Model;

public class ModelDAO implements ModelDAOI {
	private EntityManager em;

	public ModelDAO(EntityManager em) {
		this.em = em;
	}

	@Override
	public void add(Model model) {
		try {
			em.getTransaction().begin();
			em.persist(model);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.err.println(e);
			e.printStackTrace();
		}
	}

	@Override
	public List<Model> list() {
		TypedQuery<Model> query = em.createQuery("from Model", Model.class);
		return query.getResultList();
	}

	@Override
	public Model find(int id) {
		return em.find(Model.class, id);
	}

}
