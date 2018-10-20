package fr.Istic.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import fr.Istic.entities.Sport;

public interface SportRepository extends JpaRepository<Sport, Long>{
	List<Sport> findByName(String name);
}
