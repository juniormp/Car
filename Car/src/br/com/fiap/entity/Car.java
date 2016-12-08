package br.com.fiap.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CAR")
@NamedQueries({
	@NamedQuery(name="findByBrandAndDes", query="select c from Car c where c.brand=:brand and c.des=:des")
})
public class Car implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ID_CAR")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;

	@Column(name = "BRAND", length = 45)
	private String brand;

	@Column(name = "COSTO", length = 45)
	private double cost;

	@Column(name = "COLOR", length = 45)
	private String color;

	@Column(name = "DES", length = 45)
	private String des;

	@Column(name = "KM")
	private long km;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "ID_MANUFACTURER")
	private Manufacturer manufacturer;
	
	@OneToMany(cascade = CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="car")
	private List<Model> models = new ArrayList<>();
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getDesc() {
		return des;
	}

	public void setDesc(String desc) {
		this.des = desc;
	}

	public long getKm() {
		return km;
	}

	public void setKm(long km) {
		this.km = km;
	}

	public Manufacturer getManufacturer() {
		return manufacturer;
	}

	public void setManufacturer(Manufacturer manufacturer) {
		this.manufacturer = manufacturer;
	}

	public List<Model> getModels() {
		return models;
	}

	public void setModels(List<Model> models) {
		this.models = models;
	}

	public String getDes() {
		return des;
	}

	public void setDes(String des) {
		this.des = des;
	}

	

	
	
	

}
