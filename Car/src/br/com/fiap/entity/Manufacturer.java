package br.com.fiap.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="MANUFACTURER")
@NamedQueries({
	@NamedQuery(name="findByNameAndAdress", query="select m from Manufacturer m where m.name=:name and m.adress=:adress")
})
public class Manufacturer implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "ID_MANUFACTURER") 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "NAME", length = 45)
	private String name;
	
	@Column(name = "ADRESS", length = 45)
	private String adress;
	
	@Column(name = "COUNTRY", length = 45)
	private String country;

	@Column(name = "OFFICE", length = 45)
	private String office;
	
	@Column(name = "DATEBIRTH")
	private LocalDate dateBirth;
	
	@OneToMany(cascade= CascadeType.ALL, fetch=FetchType.LAZY, mappedBy="manufacturer")
	private Set<Car> cars = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public LocalDate getDateBirth() {
		return dateBirth;
	}

	public void setDateBirth(LocalDate dateBirth) {
		this.dateBirth = dateBirth;
	}

	public Set<Car> getCars() {
		return cars;
	}

	public void setCars(Set<Car> cars) {
		this.cars = cars;
	}

	@Override
	public String toString() {
		return "Manufacturer [id=" + id + ", name=" + name + ", adress=" + adress + ", country=" + country + ", office="
				+ office + ", dateBirth=" + dateBirth + ", cars=" + cars + "]";
	}
	
	
	
	
	
}
