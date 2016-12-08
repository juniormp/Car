package br.com.fiap.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import javax.persistence.EntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.fiap.entity.Car;
import br.com.fiap.entity.Manufacturer;
import br.com.fiap.entity.Model;
import br.com.fiap.entity.Secondhand;

public class CarDAOTest {

	private static EntityManager em;
	private static Car car;
	private static CarDAOI carDAO;
	private static Manufacturer manufacturer;
	private static ManufacturerDAOI manufactorDAO;
	private static List<Model> models;
	private static ModelDAOI modelDAO;

	@BeforeClass
	public static void beforeClass() {
		em = EntityManagerDAO.getInstance();
		car = new Car();
		carDAO = new CarDAO(em);
		manufactorDAO = new ManufacturerDAO(em);
		modelDAO = new ModelDAO(em);
	}

	@AfterClass
	public static void afterClass() {
		em.getTransaction().rollback();

	}

	@Test
	public void haveToAddCar() {
		
		manufacturer = manufactorDAO.find(1); 
		models = modelDAO.list();
		
		car.setBrand("BRAND");
		car.setColor("COLOR");
		car.setCost(50000.00);
		car.setDes("DES");
		car.setKm(0);
		car.setManufacturer(manufacturer);
		car.setModels(models);

		carDAO.add(car, true);

		Car newCar = carDAO.findByBrandAndDes("BRAND", "DES");

		assertEquals(car.getBrand(), newCar.getBrand());
		assertEquals(car.getDes(), newCar.getDes());

	}

}
