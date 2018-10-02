package fr.Istic.entities;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Locality implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String city;
	private String department;
	private String region;
	@ManyToMany
	private Collection<Person> persons;
	@ManyToMany
	private Collection<Sport> sports;
	
	public Locality() {
		super();
	}

	

	public Locality(String city, String department, String region, Collection<Person> persons,
			Collection<Sport> sports) {
		super();
		this.city = city;
		this.department = department;
		this.region = region;
		this.persons = persons;
		this.sports = sports;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getCity() {
		return city;
	}



	public void setCity(String city) {
		this.city = city;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	public String getRegion() {
		return region;
	}



	public void setRegion(String region) {
		this.region = region;
	}


	@JsonIgnore
	public Collection<Person> getPersons() {
		return persons;
	}


	
	public void setPersons(Collection<Person> persons) {
		this.persons = persons;
	}


	@JsonIgnore
	public Collection<Sport> getSports() {
		return sports;
	}



	public void setSports(Collection<Sport> sports) {
		this.sports = sports;
	}


	
}
