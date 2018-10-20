package fr.Istic.service;

import java.util.List;

import fr.Istic.entities.Person;

public interface PersonMetier {
	public Person savePerson(Person p);
	public List<Person> listPerson();
	public Person updatePerson(Person p);
	public Person getPersonByid(Long id);
	public void deletePerson(Long id);

}
