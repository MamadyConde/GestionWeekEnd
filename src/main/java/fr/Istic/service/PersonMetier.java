package fr.Istic.service;

import java.util.List;

import fr.Istic.entities.PersRole;
import fr.Istic.entities.Person;

public interface PersonMetier {
	public Person savePerson(Person p);
	public List<Person> listPerson();
	public Person updatePerson(Person p);
	public Person getPersonByid(Long id);
	public void deletePerson(Long id);
	public PersRole saveRole(PersRole role);
	public void addRoleToPerson(String email, String roleName);
	public Person findPersonByEmail(String email);
	//public List<Person> listRole();


	
}
