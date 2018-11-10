package fr.Istic.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.Istic.Repository.PersonRepository;
import fr.Istic.Repository.SportRepository;
import fr.Istic.entities.Person;
import fr.Istic.entities.Sport;

@Service //pour que spring puisse la reconnaitre comme un bean-spring
public class PersonMetierImpl implements PersonMetier {
	@Autowired  //injection de dependance de l'interface PersonDao par spring
	private PersonRepository personRepository;
	@Autowired
	private SportRepository sportRepository;
	
	@Override
	public Person savePerson(Person p) {
        List<Person> list = personRepository.findByEmailAndLastname(p.getEmail(), p.getLastname()); 	
        if (list.size() > 0) {
           return p ;
        } else {
		return personRepository.save(p);
        }
	}

	@Override
	public List<Person> listPerson() {
		
		return personRepository.findAll();
	}

	@Override
	public Person updatePerson(Person p) {
		System.out.println(p.getId());
		return personRepository.save(p);
	}

	@Override
	public Person getPersonByid(Long id) {
		
		return personRepository.findById(id).get();
	}

	@Override
	public void deletePerson(Long id) {
		
		 personRepository.delete(getPersonByid(id));
	}

}
