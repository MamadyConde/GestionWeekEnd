package fr.Istic.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.Istic.entities.Locality;

public interface LocalityDao extends JpaRepository<Locality, Long>{
	List<Locality> findByCity(String city);
}
