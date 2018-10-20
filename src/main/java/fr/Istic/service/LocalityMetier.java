package fr.Istic.service;

import java.util.List;

import fr.Istic.entities.Locality;

public interface LocalityMetier {
	public Locality saveLocality(Locality l);
	public List<Locality> listLocality();
	public Locality updateLocality(Locality l);
	public Locality getLocalityByid(Long id);
	public void deleteLocality(Long id);

}
