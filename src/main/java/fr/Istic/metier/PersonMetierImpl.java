package fr.Istic.metier;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.Istic.Dao.PersonDao;
import fr.Istic.entities.Person;

@Service //pour que spring puisse la reconnaitre comme un bean-spring
public class PersonMetierImpl implements PersonMetier {
	@Autowired  //injection de dependance de l'interface PersonDao par spring
	private PersonDao personDao;
	
	@Override
	public Person savePerson(Person p) {
        List<Person> list = personDao.findByEmailAndLastname(p.getEmail(), p.getLastname()); 	
        if (list.size() > 0) {
           return p ;
        } else {
		return personDao.save(p);
        }
	}

	@Override
	public List<Person> listPerson() {
		
		return personDao.findAll();
	}

	@Override
	public Person updatePerson(Person p) {
		System.out.println(p.getId());
		return personDao.save(p);
	}

	@Override
	public Person getPersonByid(Long id) {
		
		return personDao.findById(id).get();
	}

	@Override
	public void deletePerson(Long id) {
		
		 personDao.delete(getPersonByid(id));
	}

}
