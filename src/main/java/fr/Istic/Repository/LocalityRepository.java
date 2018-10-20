package fr.Istic.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.Istic.entities.Locality;

public interface LocalityRepository extends JpaRepository<Locality, Long>{
	List<Locality> findByCity(String city);
}
