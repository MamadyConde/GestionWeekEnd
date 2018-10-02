package fr.Istic.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.Istic.Dao.LocalityDao;
import fr.Istic.entities.Locality;

@Service
public class LocalityMetierImpl implements LocalityMetier {
	@Autowired
	private LocalityDao localityDao;
	@Override
	public Locality saveLocality(Locality l) {
		List<Locality> list=localityDao.findByCity(l.getCity());
		if(list.size()>0) {
			return l;
		}else {
		return localityDao.save(l);
		}
	}

	@Override
	public List<Locality> listLocality() {
		
		return localityDao.findAll();
	}

	@Override
	public Locality updateLocality(Locality l) {
		
		return localityDao.save(l);
	}

	@Override
	public Locality getLocalityByid(Long id) {
		
		return localityDao.findById(id).get();
	}

	@Override
	public void deleteLocality(Long id) {
		localityDao.delete(getLocalityByid(id));

	}

}
