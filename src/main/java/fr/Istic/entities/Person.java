package fr.Istic.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;



@Entity
public class Person implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private Long id;
	private String firstname;
	private String lastname;
	@Column(unique=true)
	private String email;
	private String password;
	
	@ManyToMany(fetch=FetchType.EAGER)
	private Collection<PersRole> roles = new ArrayList<>();
	
	@ManyToMany
	private Collection<Sport> sports;
	@ManyToMany
	private Collection<Locality> locality;
	
	public Person() {
		super();
	}

	
	public Person(String firstname, String lastname, String email, String password, Collection<PersRole> roles,
			Collection<Sport> sports, Collection<Locality> locality) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.sports = sports;
		this.locality = locality;
	}




	public Person(String firstname, String lastname, String email, String password, Collection<Sport> sports,
			Collection<Locality> locality) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.sports = sports;
		this.locality = locality;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Collection<Sport> getSports() {
		return sports;
	}

	public void setSports(Collection<Sport> sports) {
		this.sports = sports;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonSetter
	public void setPassword(String password) {
		this.password = password;
	}


	public Collection<PersRole> getRoles() {
		return roles;
	}


	public void setRoles(Collection<PersRole> roles) {
		this.roles = roles;
	}
	public Collection<Locality> getLocality() {
		return locality;
	}


	public void setLocality(Collection<Locality> locality) {
		this.locality = locality;
	}


	
	
	
}