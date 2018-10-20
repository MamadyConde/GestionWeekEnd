package fr.Istic.service;

import java.util.List;

import fr.Istic.entities.Sport;

public interface SportMetier {
	public Sport saveSport(Sport s);
	public List<Sport> listSport();
	public Sport Update(Sport s);
	public Sport getSportByid(long id);
	public void deleteSport(long id);
}
