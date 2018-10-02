package fr.Istic.metier;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.Istic.Dao.SportDao;
import fr.Istic.entities.Sport;
@Service
public class SportMetierImpl implements SportMetier{
	
	@Autowired
	private SportDao sportDao; //faire appel à DAO
	@Override
	public Sport saveSport(Sport s) {
		List <Sport> list =sportDao.findByName(s.getName());
		if(list.size()>0) {
			return s;
		}else {
		return sportDao.save(s);
		}
	}

	@Override
	public List<Sport> listSport() {
		
		return sportDao.findAll();
	}

	@Override
	public Sport Update(Sport s) {
		
		return sportDao.save(s);
	}

	@Override
	public Sport getSportByid(long id) {
		
		return sportDao.findById(id).get();
	}

	@Override
	public void deleteSport(long id) {
		sportDao.delete(getSportByid(id));
		
	}

}
