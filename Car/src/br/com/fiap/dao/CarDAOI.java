package br.com.fiap.dao;

import java.util.List;

import br.com.fiap.entity.Car;

public interface CarDAOI {

	public void add(Car car, boolean isTest);

	public List<Car> list();

	public Car find(int id);
	
	public Car findByBrandAndDes(String brand, String des);
	
}
