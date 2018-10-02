package fr.Istic.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.Istic.entities.Person;

public interface PersonDao extends JpaRepository<Person,Long>{
	List<Person> findByEmail(String email);
    List<Person> findByLastname(String lastname);
    List<Person> findByEmailAndLastname(String email, String lastname);

}
