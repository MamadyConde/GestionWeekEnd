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

import fr.Istic.entities.Sport;
import fr.Istic.service.SportMetier;

@RestController
@CrossOrigin("*")
@RequestMapping("/Sport")
public class SportRestService {
	@Autowired
	private SportMetier sportMetier;
	
	
	@PostMapping(value="/Add")
	public Sport saveSport(@RequestBody Sport s) {
System.out.println("sssss "+s);
		return sportMetier.saveSport(s);
	}
	@GetMapping(value="/List")
	public List<Sport> listSport() {
		return sportMetier.listSport();
	}
	@PutMapping(value="/Update/{id}")
	public Sport Update(@PathVariable Long id,@RequestBody Sport s) {
		//s.setId(id);
		System.out.println("sport "+s);
		return sportMetier.Update(s);
	}
	@GetMapping(value="/One/{id}")
	public Sport getSportByid(@PathVariable Long id) {
		return sportMetier.getSportByid(id);
	}
	@DeleteMapping(value="/Delete/{id}")
	public boolean deleteSport(@PathVariable("id") Long id) {
		sportMetier.deleteSport(id);
		return true;
	}

}
