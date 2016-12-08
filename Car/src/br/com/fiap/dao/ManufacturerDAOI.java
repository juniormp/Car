package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Manufacturer;

public interface ManufacturerDAOI {

	public void add(Manufacturer manufacturer, boolean isTest);

	public List<Manufacturer> list();

	public Manufacturer find(int id);
	
	public Manufacturer findByNameAndAdress(String name, String adress);
	
		
}
