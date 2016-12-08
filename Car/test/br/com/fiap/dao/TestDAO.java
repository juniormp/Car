package br.com.fiap.dao;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;

import br.com.fiap.entity.Car;
import br.com.fiap.entity.Manufacturer;
import br.com.fiap.entity.Model;
import br.com.fiap.entity.Secondhand;

public class TestDAO {

	private static EntityManager em = EntityManagerDAO.getInstance();
	private static ManufacturerDAO manufacturerDAO = new ManufacturerDAO(em);
	private static Car car = new Car();
	private static CarDAOI carDAO = new CarDAO(em);
	private static Manufacturer manufacturer;
	private static ManufacturerDAOI manufactorDAO;
	private static List<Model> models;
	private static ModelDAO modelDAO = new ModelDAO(em);

	public static void main(String[] args) {

		em = EntityManagerDAO.getInstance();
		manufacturerDAO = new ManufacturerDAO(em);
		/// Manufacturer newManufacturer =
		/// manufacturerDAO.findByNameAndAdress("NAME2", "ADRESS2");
	

	}

	public static void nada() {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyy");

		Manufacturer manufacturer = new Manufacturer();
		manufacturer.setName("NAOETESTE3");
		manufacturer.setOffice("NAOETESTE2");
		manufacturer.setAdress("DENAOETESTEU2");
		manufacturer.setCountry("NAOETESTE2");
		LocalDate date = LocalDate.now();
		manufacturer.setDateBirth(date);

		Car car = new Car();
		car.setBrand("NAOETESTE2");
		car.setCost(50000.00);
		car.setColor("NAOETESTE2");
		car.setDesc("NAOETESTE2");
		car.setKm(0);
		car.setManufacturer(manufacturer);

		manufacturer.getCars().add(car);

		Model model = new Model();
		model.setDesc("NAOETESTE2");
		LocalDate date2 = LocalDate.now();
		date2.getYear();
		model.setYear(date2);
		model.setCar(car);

		car.getModels().add(model);

		manufacturerDAO.add(manufacturer, false);

		System.out.println("\n Fabricante inserido com sucesso! ");
		System.out.println("Nome do fabricante: " + manufacturer.getName());
		System.out.println("---------------------------------");
		System.out.println("Carro inserido com sucesso! ");
		System.out.println("DescriÁ„o do carro: " + car.getDesc());
		System.out.println("---------------------------------");
		System.out.println("Modelo inserido com sucesso! ");
		System.out.println("DescriÁ„o do modelo: " + model.getDesc());
	}

}
