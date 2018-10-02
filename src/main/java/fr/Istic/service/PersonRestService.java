package fr.Istic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.Istic.entities.Person;
import fr.Istic.metier.PersonMetier;

@RestController//par default JSON
public class PersonRestService {
	
	@Autowired
	private PersonMetier personMetier; 
	
	@PostMapping(value="/AddPerson")
	public Person saveClient(@RequestBody Person p) {
		 personMetier.savePerson(p);
		 return personMetier.savePerson(p);
	}

	@GetMapping(value="/listPerson")
	public List<Person> listPerson() {
		return personMetier.listPerson();
	}
	
	@PutMapping(value="/UpdatePerson")
	public Person update(@RequestBody Person p) {
		return personMetier.updatePerson(p);
	}

	@GetMapping(value="/OnePerson/{id}")
	public Person getPersonByid(@PathVariable("id") Long id) {
		return personMetier.getPersonByid(id);
	}
	@DeleteMapping(value="/DeletePerson/{id}")
	public void deletePerson( @PathVariable("id") Long id) {
		personMetier.deletePerson(id);
	}
	
	
}
