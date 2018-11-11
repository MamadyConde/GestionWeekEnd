package fr.Istic.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.Istic.entities.Person;

public interface PersonRepository extends JpaRepository<Person,Long>{
	List<Person> findByFirstname(String firstname);
    List<Person> findByLastname(String lastname);
    List<Person> findByEmailAndLastname(String email, String lastname);
   public Person findByEmail(String email);

}
