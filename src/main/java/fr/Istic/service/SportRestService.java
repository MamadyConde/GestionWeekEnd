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

import fr.Istic.entities.Sport;
import fr.Istic.metier.SportMetier;

@RestController
public class SportRestService {
	@Autowired
	private SportMetier sportMetier;
	
	@PostMapping(value="/AddSport")
	public Sport saveSport(@RequestBody Sport s) {
		return sportMetier.saveSport(s);
	}
	@GetMapping(value="/listSport")
	public List<Sport> listSport() {
		return sportMetier.listSport();
	}
	@PutMapping(value="/UpdateSport")
	public Sport Update(@RequestBody Sport s) {
		return sportMetier.Update(s);
	}
	@GetMapping(value="/OneSport/{id}")
	public Sport getSportByid(@PathVariable long id) {
		return sportMetier.getSportByid(id);
	}
	@DeleteMapping(value="/DeleteSport/{id}")
	public void deleteSport(@PathVariable long id) {
		sportMetier.deleteSport(id);
	}

}
