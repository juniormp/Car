package br.com.fiap.dao;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.fiap.entity.Car;
import br.com.fiap.entity.Manufacturer;

public class ManufacturerDAOTest {

	private static EntityManager em;
	private static Manufacturer manufacturer;
	private static ManufacturerDAOI manufacturerDAO;
	private static CarDAOI carDAO;
	private List<Manufacturer> manufacturers;
	private List<Car> cars;

	@BeforeClass
	public static void beforeClass() {
		em = EntityManagerDAO.getInstance();
		manufacturer = new Manufacturer();
		manufacturerDAO = new ManufacturerDAO(em);
		carDAO = new CarDAO(em);

	}

	@AfterClass
	public static void afterClass() {
		em.getTransaction().rollback();

	}

	@Test
	public void haveToAddManufacturer() {

		cars = carDAO.list();
		Set<Car> carss = new LinkedHashSet<>(cars);

		manufacturer.setName("NAME");
		manufacturer.setOffice("OFFICE");
		manufacturer.setAdress("ADRESS");
		manufacturer.setCountry("COUNTRY");
		LocalDate date = LocalDate.now();
		manufacturer.setDateBirth(date);
		manufacturer.setCars(carss);

		manufacturerDAO.add(manufacturer, true);

		Manufacturer newManufacturer = manufacturerDAO.findByNameAndAdress(manufacturer.getName(),
				manufacturer.getAdress());

		System.out.println(newManufacturer.toString());
		
		assertEquals(manufacturer.getName(), newManufacturer.getName());
		assertEquals(manufacturer.getAdress(), newManufacturer.getAdress());

	}

	@Test
	public void haveToFindManufacturerById() {

		manufacturer = manufacturerDAO.findByNameAndAdress("TEST", "TEST");

		assertEquals(1, manufacturer.getId());

	}

	@Test
	public void haveToFindAllManufacturer() {
		// First Size
		manufacturers = manufacturerDAO.list();
		int firstSize = manufacturers.size();

		// Adding a new manufacturer
		cars = carDAO.list();
		Set<Car> carss = new LinkedHashSet<>(cars);
		manufacturer.setName("NAME");
		manufacturer.setOffice("OFFICE");
		manufacturer.setAdress("ADRESS");
		manufacturer.setCountry("COUNTRY");
		LocalDate date = LocalDate.now();
		manufacturer.setDateBirth(date);
		manufacturer.setCars(carss);
		manufacturerDAO.add(manufacturer, true);

		// Second Size
		manufacturers = manufacturerDAO.list();

		assertEquals((firstSize + 1), manufacturers.size());

	}

}
