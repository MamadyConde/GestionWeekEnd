package fr.Istic.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import fr.Istic.entities.Locality;
import fr.Istic.service.LocalityMetier;

@RestController
@CrossOrigin("*")
@RequestMapping("/Locality")
public class LocalityRestService {
	@Autowired
	private LocalityMetier localityMetier;
	
	@PostMapping(value="/Add")
	public Locality saveLocality(@RequestBody Locality l) {
		return localityMetier.saveLocality(l);
	}
	
	@GetMapping(value="/List")
	public List<Locality> listLocality() {
		return localityMetier.listLocality();
	}
	
	@PutMapping(value="/Update/{id}")
	public Locality updateLocality(@PathVariable Long id, @RequestBody Locality l) {
		l.setId(id);
		return localityMetier.updateLocality(l);
	}

	@GetMapping(value="/One/{id}")
	public Locality getLocalityByid(@PathVariable Long id) {
		return localityMetier.getLocalityByid(id);
	}

	@DeleteMapping(value="/Delete/{id}")
	public void deleteLocality(@PathVariable Long id) {
		localityMetier.deleteLocality(id);
	}
}
