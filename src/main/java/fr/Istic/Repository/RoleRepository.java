package fr.Istic.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.Istic.entities.PersRole;

public interface RoleRepository extends JpaRepository<PersRole,Long>{
	public List<PersRole> findByRoleName(String roleName);
	

}
