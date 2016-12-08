package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Model;

public interface ModelDAOI {

	public void add(Model model);

	public List<Model> list();

	public Model find(int id);
	
	
}
