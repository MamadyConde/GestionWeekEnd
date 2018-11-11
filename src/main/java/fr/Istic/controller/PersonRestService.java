package fr.Istic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.Istic.entities.Person;
import fr.Istic.service.PersonMetier;

@RestController//par default JSON
@CrossOrigin("*")
@RequestMapping("/Person")
public class PersonRestService {
	
	@Autowired
	private PersonMetier personMetier; 
	
	@GetMapping(value="/List")
	public List<Person> listPerson() {
		return personMetier.listPerson();
	}
	@PostMapping(value="/Add")
	public Person saveClient(@RequestBody Person p) {
		 //personMetier.savePerson(p);
		 personMetier.savePerson(p);
		 personMetier.addRoleToPerson(p.getEmail(), "USER");//par defaut role user
		 return p;
	}

	
	@PutMapping(value="/Update/{id}")
	public Person update(@PathVariable Long id,@RequestBody Person p) {
		p.setId(id);
		return personMetier.updatePerson(p);
	}

	@GetMapping(value="/One/{id}")
	public Person getPersonByid(@PathVariable("id") Long id) {
		return personMetier.getPersonByid(id);
	}
	@DeleteMapping(value="/Delete/{id}")
	public boolean deletePerson( @PathVariable("id") Long id) {
		personMetier.deletePerson(id);
		return true;
	}
	
	
}
