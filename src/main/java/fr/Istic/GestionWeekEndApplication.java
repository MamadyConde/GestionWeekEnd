package fr.Istic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import fr.Istic.Repository.PersonRepository;
import fr.Istic.entities.PersRole;
import fr.Istic.entities.Person;
import fr.Istic.service.PersonMetier;

@SpringBootApplication
public class GestionWeekEndApplication implements CommandLineRunner{
	@Autowired
	private PersonRepository personRepository;
	@Autowired
	private PersonMetier personMetier;

	public static void main(String[] args) {
		SpringApplication.run(GestionWeekEndApplication.class, args);
	}
	@Bean
	public BCryptPasswordEncoder getBCPE() { 
		return new BCryptPasswordEncoder();
	}
	@Override
	public void run(String... args) throws Exception {
		personMetier.savePerson(new Person("admin","admin","admin@gmail.fr","12",null,null));
		personMetier.savePerson(new Person("user","user","user@gmail.fr","12",null,null));
		personMetier.saveRole(new PersRole("ADMIN"));
		personMetier.saveRole(new PersRole("USER"));
		personMetier.addRoleToPerson("admin@gmail.fr", "ADMIN");
		personMetier.addRoleToPerson("admin@gmail.fr", "USER");
		personMetier.addRoleToPerson("user@gmail.fr", "USER");
	
	}
}
