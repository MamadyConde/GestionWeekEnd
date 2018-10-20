package fr.Istic.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.Istic.Repository.LocalityRepository;
import fr.Istic.entities.Locality;

@Service
public class LocalityMetierImpl implements LocalityMetier {
	@Autowired
	private LocalityRepository localityRepository;
	@Override
	public Locality saveLocality(Locality l) {
		List<Locality> list=localityRepository.findByCity(l.getCity());
		if(list.size()>0) {
			return l;
		}else {
		return localityRepository.save(l);
		}
	}

	@Override
	public List<Locality> listLocality() {
		
		return localityRepository.findAll();
	}

	@Override
	public Locality updateLocality(Locality l) {
		
		return localityRepository.save(l);
	}

	@Override
	public Locality getLocalityByid(Long id) {
		
		return localityRepository.findById(id).get();
	}

	@Override
	public void deleteLocality(Long id) {
		localityRepository.delete(getLocalityByid(id));

	}

}
