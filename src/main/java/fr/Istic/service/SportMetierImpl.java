package fr.Istic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.Istic.Repository.SportRepository;
import fr.Istic.entities.Sport;
@Service
public class SportMetierImpl implements SportMetier{
	
	@Autowired
	private SportRepository sportRepository; //faire appel à DAO
	@Override
	public Sport saveSport(Sport s) {
		List <Sport> list =sportRepository.findByName(s.getName());
		if(list.size()>0) {
			return s;
		}else {
		return sportRepository.save(s);
		}
	}

	@Override
	public List<Sport> listSport() {
		
		return sportRepository.findAll();
	}

	@Override
	public Sport Update(Sport s) {
		
		return sportRepository.save(s);
	}

	@Override
	public Sport getSportByid(long id) {
		
		return sportRepository.findById(id).get();
	}

	@Override
	public void deleteSport(long id) {
		sportRepository.delete(getSportByid(id));
		
	}

}
