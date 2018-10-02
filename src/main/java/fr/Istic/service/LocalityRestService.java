package fr.Istic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import fr.Istic.entities.Locality;
import fr.Istic.metier.LocalityMetier;

@RestController
public class LocalityRestService {
	@Autowired
	private LocalityMetier localityMetier;
	
	@PostMapping(value="/AddLocality")
	public Locality saveLocality(@RequestBody Locality l) {
		return localityMetier.saveLocality(l);
	}
	
	@GetMapping(value="/ListLocality")
	public List<Locality> listLocality() {
		return localityMetier.listLocality();
	}
	
	@PutMapping(value="/UpdateLocality")
	public Locality updateLocality(@RequestBody Locality l) {
		return localityMetier.updateLocality(l);
	}

	@GetMapping(value="/OneLocality/{id}")
	public Locality getLocalityByid(@PathVariable Long id) {
		return localityMetier.getLocalityByid(id);
	}

	@DeleteMapping(value="/DeleteLocality/{id}")
	public void deleteLocality(@PathVariable Long id) {
		localityMetier.deleteLocality(id);
	}
}
