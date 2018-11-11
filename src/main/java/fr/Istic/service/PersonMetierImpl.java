package fr.Istic.service;

import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.Istic.Repository.PersonRepository;
import fr.Istic.Repository.RoleRepository;
import fr.Istic.Repository.SportRepository;
import fr.Istic.entities.PersRole;
import fr.Istic.entities.Person;
import fr.Istic.entities.Sport;

@Service //pour que spring puisse la reconnaitre comme un bean-spring
@Transactional

public class PersonMetierImpl implements PersonMetier {
	@Autowired  //injection de dependance de l'interface PersonDao par spring
	private PersonRepository personRepository;
	@Autowired
	private SportRepository sportRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private RoleRepository roleRepository;
	@Override
	public Person savePerson(Person p) {
        List<Person> list = personRepository.findByEmailAndLastname(p.getEmail(), p.getLastname()); 	
        if (list.size() > 0) {
           return p ;
        } else {
        	String hashPW=bCryptPasswordEncoder.encode(p.getPassword());
        	p.setPassword(hashPW);
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

	@Override
	public PersRole saveRole(PersRole r) {
		  List<PersRole> list = roleRepository.findByRoleName(r.getRoleName()); 	
	        if (list.size() > 0) {
	           return r ;
	        } else {
	        
		return roleRepository.save(r);
	     }
	}

	@Override
	public void addRoleToPerson(String email, String roleName) {
		List<PersRole> role = roleRepository.findByRoleName(roleName);
		Person p =  personRepository.findByEmail(email);
		p.getRoles().addAll(role);
		
	}

	@Override
	public Person findPersonByEmail(String email) {
		// TODO Auto-generated method stub
		return  personRepository.findByEmail(email);
	}

}
