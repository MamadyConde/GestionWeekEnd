package fr.Istic.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.Istic.entities.Person;
@CrossOrigin("*")
public class controlerTest {

	@RequestMapping("/user")
	  public Person user(Person user) {
	    return null;
	  }
}
