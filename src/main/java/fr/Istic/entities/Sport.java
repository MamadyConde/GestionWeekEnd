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
public class Sport implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long level;

	@ManyToMany
	private Collection<Locality> locality;
	
	@ManyToMany(mappedBy ="sports")
	private Collection<Person> person;
	
	
	public Sport() {
		super();
	}



	public Sport(String name, Long level, Collection<Locality> locality) {
		super();
		this.name = name;
		this.level = level;
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

	
	public Collection<Locality> getLocality() {
		return locality;
	}



	public void setLocality(Collection<Locality> locality) {
		this.locality = locality;
	}


	@JsonIgnore //pour personne
	public Collection<Person> getPerson() {
		return person;
	}


	
	public void setPerson(Collection<Person> person) {
		this.person = person;
	}


}