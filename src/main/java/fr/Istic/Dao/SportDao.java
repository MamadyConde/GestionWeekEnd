package fr.Istic.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.Istic.entities.Sport;

public interface SportDao extends JpaRepository<Sport, Long>{
	List<Sport> findByName(String name);
}
