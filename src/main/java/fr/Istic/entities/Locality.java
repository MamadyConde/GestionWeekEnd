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
	
	@ManyToMany(mappedBy="locality")
	private Collection<Sport> sports;
	
	public Locality() {
		super();
	}


	public Locality(String city, Collection<Sport> sports) {
		super();
		this.city = city;
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

	@JsonIgnore //pour la personne
	public Collection<Sport> getSports() {
		return sports;
	}


	public void setSports(Collection<Sport> sports) {
		this.sports = sports;
	}


	



	
}