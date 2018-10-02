package fr.Istic.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Sport implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long level;
	
	@ManyToMany(mappedBy="sports")
	private Collection<Person> persons;
	@ManyToMany(mappedBy="sports")
	private Collection<Locality> locality;
	
	public Sport() {
		super();
	}



	public Sport(String name, Long level, Collection<Person> persons, Collection<Locality> locality) {
		super();
		this.name = name;
		this.level = level;
		this.persons = persons;
		this.locality = locality;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Long getLevel() {
		return level;
	}



	public void setLevel(Long level) {
		this.level = level;
	}


	@JsonIgnore
	public Collection<Person> getPersons() {
		return persons;
	}


	
	public void setPersons(Collection<Person> persons) {
		this.persons = persons;
	}


	@JsonIgnore
	public Collection<Locality> getLocality() {
		return locality;
	}



	public void setLocality(Collection<Locality> locality) {
		this.locality = locality;
	}


}
